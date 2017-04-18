package chapter16;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by xdcao on 2017/4/18.
 */
public class SimpleTriggerRunner {

    public static void main(String[] args){
        try {
            JobDetail jobDetail=new JobDetail("job1_1","jGroup1",SimpleJob.class);
            SimpleTrigger simpleTrigger=new SimpleTrigger("trigger1_1","tGroup1");
            simpleTrigger.setStartTime(new Date());
            simpleTrigger.setRepeatInterval(2000);
            simpleTrigger.setRepeatCount(100);
            SchedulerFactory schedulerFactory=new StdSchedulerFactory();
            Scheduler scheduler=schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,simpleTrigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
