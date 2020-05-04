package com.topera;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class JobA implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Job A running...");
    }

}
