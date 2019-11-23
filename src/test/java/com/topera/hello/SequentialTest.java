package com.topera.hello;

import java.util.List;
import java.util.Random;

public class SequentialTest extends BaseTest {

    @Override
    protected void printTestInfo() {
        System.out.println("\nRunning SequentialTest");
    }

    @Override
    protected void calculateMagicNumbers(List<User> users) {
        users.forEach(userIgnoredHere -> calculateMagicNumber());
    }

    @Override
    protected void addAges(List<User> users) {
        Random random = new Random();
        users.forEach(user -> user.setAge(random.nextInt(MAX_AGE)));
    }

    @Override
    protected void prepareUsers(List<User> users) {
        users.forEach(user -> user.prepare(KID_AGE_LIMIT));
    }

    @Override
    protected long countKids(List<User> users) {
        return users.stream().filter(User::isKid).count();
    }

}