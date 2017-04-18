package chapter101112131415;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by xdcao on 2017/4/18.
 */
@Service
@Qualifier(value = "userService")
public class UserJdbcWithoutTransactionManagerService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addSocre(String username,int toAdd){
        String sql="UPDATE t_user u SET u.credit=u.credit+? WHERE user_name=?";
        jdbcTemplate.update(sql,toAdd,username);
    }

}
