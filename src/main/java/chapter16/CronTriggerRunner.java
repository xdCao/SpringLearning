package chapter16;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * Created by xdcao on 2017/4/18.
 */
public class CronTriggerRunner {

    public static void main(String[] args){
        try {
            JobDetail jobDetail=new JobDetail("job1_2","jGroup1",SimpleJob.class);
            CronTrigger cronTrigger=new CronTrigger("trigger1_2","tGroup1");
            CronExpression cronExpression=new CronExpression("0/5 * * * * ?");
            cronTrigger.setCronExpression(cronExpression);
            SchedulerFactory schedulerFactory=new StdSchedulerFactory();
            Scheduler scheduler=schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,cronTrigger);
            scheduler.start();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
