package com.topera.hello;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class BaseTest {

    // customizations
    private static final long MEGA_USERS = 10;
    static final int KID_AGE_LIMIT = 12;
    private static final float KID_AGE_MARGIN = 0.1f;
    private static final int TESTS_EXECUTION = 4;

    // inner stuff
    private static final long MEGA = 1000000;
    private static final long USERS = MEGA_USERS * MEGA;
    private static final int MAX_AGE = 100;

    protected abstract void printTestInfo();
    protected abstract void prepareUsers(List<User> users);
    protected abstract long countKids(List<User> users);

    @Test
    public void test() {
        printTestInfo();
        for(int i=0; i < TESTS_EXECUTION; i++){
            runTest();
        }
    }

    private void runTest() {
        List<User> users = createUsers();

        long begin = System.currentTimeMillis();

        prepareUsers(users);
        long kidsQuantity = countKids(users);

        long end = System.currentTimeMillis();

        double percentage = ((double) kidsQuantity / (double) USERS) * 100;
        assertions(users, kidsQuantity, percentage);

        printTimeReport(begin, end, percentage);
    }
    private void printTimeReport(long begin, long end, double percentage) {
        System.out.println("*** Time taken: " + (end - begin) + "ms *** " + percentage + "% of users are kids");
    }

    private void assertions(List<User> users, long kidsQuantity, double percentage) {
        assert users.size() == USERS;
        assert kidsQuantity >= 0;
        assert kidsQuantity <= USERS;
        assert percentage > KID_AGE_LIMIT - KID_AGE_MARGIN;
        assert percentage < KID_AGE_LIMIT + KID_AGE_MARGIN;
    }

    private List<User> createUsers() {
        Random random = new Random();

        List<User> users = new ArrayList<>();

        for(int i=0; i < USERS; i++) {
            users.add(new User(random.nextInt(MAX_AGE)));
        }

        return users;
    }

}