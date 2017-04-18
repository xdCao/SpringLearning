package chapter101112131415;

import chapter3.Application;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xdcao on 2017/4/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class testJdbc {

    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        UserJdbcWithoutTransactionManagerService service= (UserJdbcWithoutTransactionManagerService) ctx.getBean("userService");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
        BasicDataSource dataSource= (BasicDataSource) jdbcTemplate.getDataSource();
        System.out.println("autoCommit:"+dataSource.getDefaultAutoCommit());
        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,credit) VALUES ('caohao','940620',10)");
        service.addSocre("caohao",20);
        String sql="SELECT credit FROM t_user WHERE user_name='caohao'";
        int credit=jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println("credits: "+credit);
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='caohao'");
    }

}
