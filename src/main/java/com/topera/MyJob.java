package com.topera;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        try {
            Thread.sleep(500);
            Main.log("Job running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
