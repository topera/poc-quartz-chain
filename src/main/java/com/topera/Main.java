package com.topera;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.listeners.JobChainingJobListener;

public class Main {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobA = JobBuilder.newJob(JobA.class).build();
        JobDetail jobB = JobBuilder.newJob(JobB.class).storeDurably(true).build();

        JobChainingJobListener jobListener = new JobChainingJobListener("ChainListener");
        jobListener.addJobChainLink(jobA.getKey(), jobB.getKey());

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobA, TriggerBuilder.newTrigger().startNow().build());
        scheduler.addJob(jobB, true);
        scheduler.getListenerManager().addJobListener(jobListener);
        scheduler.start();
    }

    public static class JobA implements Job {
        @Override
        public void execute(JobExecutionContext context) {
            System.out.println("Job A running...");
        }
    }

    public static class JobB implements Job {
        @Override
        public void execute(JobExecutionContext context) {
            System.out.println("Job B running...");
        }
    }

}