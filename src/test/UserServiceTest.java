import chapter3.Application;
import chapter3.User;
import chapter3.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xdcao on 2017/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    //成功
    @Test
    public void testUser(){
        boolean has=userService.hasMatchUser("tom","1234");
        System.out.println(has);
        System.out.println(has);
        System.out.println(has);
        System.out.println(has);
        System.out.println(has);
        System.out.println(has);
    }

    @Test
    public void findUser(){
        User user=userService.findUserByUserName("tom","1234");
        System.out.println("id:                   "+user.getUserId());
    }

}
