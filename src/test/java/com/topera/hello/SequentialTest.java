package com.topera.hello;

import java.util.List;

public class SequentialTest extends BaseTest {

    @Override
    protected void printTestInfo() {
        System.out.println("\nRunning SequentialTest");
    }

    @Override
    protected void processUsers(List<User> users) {
        users.forEach(this::processUser);
    }

}