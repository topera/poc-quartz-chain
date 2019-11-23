package com.topera.hello;

import com.aparapi.Kernel;
import com.aparapi.Range;

import org.junit.Ignore;

import java.util.List;

@Ignore
public class ParallelGraphCardTest extends BaseTest {

    @Override
    protected void printTestInfo() {
        System.out.println("\nRunning ParallelGraphCardTest");
    }

    @Override
    protected void processUsers(List<User> users) {
        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                processUser(users.get(i));
            }
        };

        Range range = Range.create(users.size());
        kernel.execute(range);
    }

}