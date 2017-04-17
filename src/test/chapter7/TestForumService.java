package chapter7;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by xdcao on 2017/4/14.
 */
public class TestForumService {

    @Test
    public void test(){
        ForumService forumService=new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }

    @Test
    public void testProxy(){
        ForumService target=new ForumServiceImpl();
        PerformanceHandler handler=new PerformanceHandler(target);
        ForumService proxy=(ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }

    @Test
    public void testCglib(){
        CglibProxy proxy=new CglibProxy();
        ForumServiceImpl forumService=(ForumServiceImpl)proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }

}
