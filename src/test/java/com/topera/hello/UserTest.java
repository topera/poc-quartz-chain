package com.topera.hello;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("SimplifyStreamApiCallChains")
public class UserTest {

    // customizations
    private static final long MEGA_USERS = 5;
    private static final int KID_AGE_LIMIT = 12;
    private static final float KID_AGE_MARGIN = 0.1f;

    // inner stuff
    private static final long MEGA = 1000000;
    private static final long USERS = MEGA_USERS * MEGA;
    private static final int MAX_AGE = 100;

    @Test
    public void check() {
        long begin = System.currentTimeMillis();

        List<User> users = createUsers();
        prepareUsers(users);
        long kidsQuantity = countKids(users);

        printTimeReport(begin);

        assertions(users, kidsQuantity);
    }

    private void printTimeReport(long begin) {
        long end = System.currentTimeMillis();
        System.out.println("*** Time taken: " + (end - begin) + "ms ***");
    }

    private void assertions(List<User> users, long kidsQuantity) {
        double percentage = ((double) kidsQuantity / (double) USERS) * 100;
        System.out.println(kidsQuantity + " users are kids (" + percentage + "%)");

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

    private void prepareUsers(List<User> users) {
        users.stream().forEach(user -> user.prepare(KID_AGE_LIMIT));
    }

    private long countKids(List<User> users) {
        return users.stream().filter(User::isKid).count();
    }

}