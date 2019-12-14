package com.topera.hello;

import com.aparapi.Kernel;
import com.aparapi.Range;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class GPUTest {

    // customizations
    private static final int ITEMS_SIZE = 500; // on millions
    private static final int TESTS_EXECUTION = 3;

    // inner stuff
    private static final int MEGA = 1000000;
    private static final int FINAL_SIZE = MEGA * ITEMS_SIZE;

    @Test
    public void test() {
        for(int i=0; i < TESTS_EXECUTION; i++){
            runTest();
        }
    }

    private void runTest() {
        int[] items = new int[FINAL_SIZE];

        Instant begin = Instant.now();
        processItems(items);
        Instant end = Instant.now();

        assertions(items);

        printReport(items, begin, end);
    }

    protected void processItems(int[] items) {
        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                items[i] = i;
            }
        };

        Range range = Range.create(items.length);
        kernel.execute(range);
    }

    private void printReport(int[] items, Instant begin, Instant end) {
        long duration = Duration.between(begin, end).toMillis();
        System.out.println("*** Time taken: " + (duration) + "ms *** Processed " + (items.length / MEGA) + " million items");
    }

    private void assertions(int[] items) {
        assert items.length == FINAL_SIZE;
    }

}