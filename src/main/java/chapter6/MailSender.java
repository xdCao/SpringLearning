package chapter6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by xdcao on 2017/4/13.
 */
@Component
@Qualifier(value = "mailSender")
public class MailSender implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx=applicationContext;
    }

    public void sendMail(String to){
        System.out.println("MailSender: 模拟发送邮件");
        MailSendEvent mailSendEvent=new MailSendEvent(this.ctx,to);
        ctx.publishEvent(mailSendEvent);
    }


}
