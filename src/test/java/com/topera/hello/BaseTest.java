package com.topera.hello;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class BaseTest {

    // customizations
    private static final long MEGA_USERS = 2;
    private static final int TESTS_EXECUTION = 4;

    private static final int KID_AGE_LIMIT = 12;
    private static final float KID_AGE_MARGIN = 0.1f;

    // inner stuff
    private static final long MEGA = 1000000;
    private static final long USERS = MEGA_USERS * MEGA;
    private static final int MAX_AGE = 100;
    private static final Random random = new Random();

    protected abstract void printTestInfo();
    protected abstract void processUsers(List<User> users);

    @Test
    public void test() {
        printTestInfo();
        for(int i=0; i < TESTS_EXECUTION; i++){
            runTest();
        }
    }

    private void runTest() {
        List<User> users = createUsers();

        Instant begin = Instant.now();
        processUsers(users);
        Instant end = Instant.now();

        long kidsQuantity = users.stream().filter(User::isKid).count();
        double percentage = ((double) kidsQuantity / (double) USERS) * 100;
        assertions(users, kidsQuantity, percentage);

        printTimeReport(begin, end, percentage);
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        for(int i=0; i < USERS; i++) {
            users.add(new User());
        }
        return users;
    }

    void processUser(User user) {
        if (calculateMagicNumber() > 0) {
            user.setAge(random.nextInt(MAX_AGE));
            user.setKid(user.getAge() < KID_AGE_LIMIT);
        }
    }

    private double calculateMagicNumber() {
        // any stupid slow operation...
        int max = 15;
        double magicNumber = 0;

        for(int i=0; i<max; i++){
            for(int j=0; j<max; j++){
                for(int k=0; k<max; k++){
                    magicNumber += 1;
                }
            }
        }

        return magicNumber;
    }

    private void printTimeReport(Instant begin, Instant end, double percentage) {
        long duration = Duration.between(begin, end).toMillis();
        System.out.println("*** Time taken: " + (duration) + "ms *** " + percentage + "% of users are kids");
    }

    private void assertions(List<User> users, long kidsQuantity, double percentage) {
        assert users.size() == USERS;
        assert kidsQuantity >= 0;
        assert kidsQuantity <= USERS;
        assert percentage > KID_AGE_LIMIT - KID_AGE_MARGIN;
        assert percentage < KID_AGE_LIMIT + KID_AGE_MARGIN;
    }

}