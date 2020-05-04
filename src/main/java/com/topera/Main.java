package com.topera;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.listeners.JobChainingJobListener;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        log("BEGIN");
        Thread.sleep(1000);
        run();
        Thread.sleep(1000);
        log("END");
    }

    public static void log(String text) {
        Date date = new Date();
        System.out.println("[" + date + "] " + text);
    }

    private static void run() throws SchedulerException {
        JobDetail job1 = createJob("1");
        JobDetail job2 = createJob("2");
        JobDetail job3 = createJob("3");

        Trigger trigger = TriggerBuilder.newTrigger().startNow().build();

        JobChainingJobListener jobListener = new JobChainingJobListener("ChainListener");
        jobListener.addJobChainLink(job1.getKey(), job2.getKey());
        jobListener.addJobChainLink(job2.getKey(), job3.getKey());

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job1, trigger);
        scheduler.addJob(job2, true);
        scheduler.addJob(job3, true);
        scheduler.getListenerManager().addJobListener(jobListener);
        scheduler.start();
    }

    private static JobDetail createJob(String id) {
        Class<MyJob> clazz = MyJob.class;
        return JobBuilder
                .newJob(clazz)
                .storeDurably(true)
                .withIdentity(clazz.getName() + id, "BatchJobGroup")
                .withDescription(clazz.getName()).build();
    }

}
