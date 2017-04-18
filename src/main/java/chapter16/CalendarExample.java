package chapter16;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by xdcao on 2017/4/18.
 */
public class CalendarExample {

    public static void main(String[] args) throws Exception {

        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        Scheduler scheduler=schedulerFactory.getScheduler();
        AnnualCalendar holidays=new AnnualCalendar();
        Calendar laborDay=  new GregorianCalendar();
        laborDay.add(Calendar.MONTH,5);
        laborDay.add(Calendar.DATE,1);
        Calendar nationalDay=new GregorianCalendar();
        nationalDay.add(Calendar.MONTH,10);
        nationalDay.add(Calendar.DATE,1);
        ArrayList<Calendar> calendars=new ArrayList<Calendar>();
        calendars.add(laborDay);
        calendars.add(nationalDay);
        holidays.setDaysExcluded(calendars);
        scheduler.addCalendar("holidays",holidays,false,false);
        Date runDate= TriggerUtils.getDateOf(0,0,10,1,4);
        JobDetail job=new JobDetail("job1","group1",SimpleJob.class);
        SimpleTrigger trigger=new SimpleTrigger("trigger1","group1",runDate,null,SimpleTrigger.REPEAT_INDEFINITELY,60L*60L*1000L);
        trigger.setCalendarName("holidays");
        scheduler.scheduleJob(job,trigger);
        scheduler.start();
    }

}
