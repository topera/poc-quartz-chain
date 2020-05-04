package com.topera;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.listeners.JobChainingJobListener;

public class SampleWithSameJob {

    public static void main(String[] args) throws SchedulerException {
        JobDetail jobA = createJob("1");
        JobDetail jobB = createJob("2");

        JobChainingJobListener jobListener = new JobChainingJobListener("ChainListener");
        jobListener.addJobChainLink(jobA.getKey(), jobB.getKey());

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobA, TriggerBuilder.newTrigger().startNow().build());
        scheduler.addJob(jobB, true);
        scheduler.getListenerManager().addJobListener(jobListener);
        scheduler.start();
    }

    private static JobDetail createJob(String id) {
        JobDataMap map = new JobDataMap();
        map.put("ID", id);
        return JobBuilder
                .newJob(MyJob.class)
                .usingJobData(map)
                .storeDurably(true)
                .build();
    }

    public static class MyJob implements Job {
        @Override
        public void execute(JobExecutionContext context) {
            String id = (String) context.getMergedJobDataMap().get("ID");
            System.out.println("Job " + id + " running...");
        }
    }

}