package chapter16;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by xdcao on 2017/4/18.
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        Map dataMap=context.getJobDetail().getJobDataMap();
        String size=(String)dataMap.get("size");
        ApplicationContext ctx=(ApplicationContext)dataMap.get("applicationContext");
        System.out.println("size: "+size);
        dataMap.put("size",size+"0");


    }

}
