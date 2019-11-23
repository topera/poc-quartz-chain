package com.topera.hello;

import com.aparapi.Kernel;
import com.aparapi.Range;

import org.junit.Ignore;

import java.util.List;

@Ignore // not working yet. Needs to install a lib locally
public class ParallelGraphCardTest extends ParallelCPUTest {

    @Override
    protected void printTestInfo() {
        System.out.println("\nRunning ParallelGraphCardTest");
    }

    @Override
    protected void prepareUsers(List<User> users) {
        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                users.get(i).prepare(KID_AGE_LIMIT);
            }
        };

        Range range = Range.create(users.size());
        kernel.execute(range);
    }

}