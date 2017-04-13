package chapter6;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by xdcao on 2017/4/13.
 */
@Component
public class MailSenderListener implements ApplicationListener<MailSendEvent> {


    @Override
    public void onApplicationEvent(MailSendEvent event) {
        System.out.println("MailSenderListener: 向"+event.getTo()+"发送一封邮件");
    }

}
