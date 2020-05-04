package com.topera;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class JobB implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Job B running...");
    }

}
