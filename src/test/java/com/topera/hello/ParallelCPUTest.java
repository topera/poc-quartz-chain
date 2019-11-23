package com.topera.hello;

import java.util.List;
import java.util.Random;

public class ParallelCPUTest extends BaseTest {

    @Override
    protected void printTestInfo() {
        System.out.println("\nRunning ParallelCPUTest");
    }

    @Override
    protected void addAges(List<User> users) {
        Random random = new Random();
        users.parallelStream().forEach(user -> user.setAge(random.nextInt(MAX_AGE)));
    }

    @Override
    protected void prepareUsers(List<User> users) {
        users.parallelStream().forEach(user -> user.prepare(KID_AGE_LIMIT));
    }

    @Override
    protected long countKids(List<User> users) {
        return users.parallelStream().filter(User::isKid).count();
    }

}