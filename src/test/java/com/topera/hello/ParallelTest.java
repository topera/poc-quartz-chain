package com.topera.hello;

import java.util.List;

@SuppressWarnings("SimplifyStreamApiCallChains")
public class ParallelTest extends BaseTest {

    @Override
    protected void printTestInfo() {
        System.out.println("");
        System.out.println("Running ParallelTest");
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