package chapter6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by xdcao on 2017/4/13.
 */
public class MailSendEvent extends ApplicationContextEvent {

    private String to;

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MailSendEvent(ApplicationContext source,String to) {
        super(source);
        this.to=to;
    }

    public String getTo(){
        return this.to;
    }



}
