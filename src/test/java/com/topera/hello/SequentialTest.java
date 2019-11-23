package com.topera.hello;

import java.util.List;

@SuppressWarnings("SimplifyStreamApiCallChains")
public class SequentialTest extends BaseTest {

    @Override
    protected void printTestInfo() {
        System.out.println("Running SequentialTest");
    }

    @Override
    protected void prepareUsers(List<User> users) {
        users.stream().forEach(user -> user.prepare(KID_AGE_LIMIT));
    }

    @Override
    protected long countKids(List<User> users) {
        return users.stream().filter(User::isKid).count();
    }

}