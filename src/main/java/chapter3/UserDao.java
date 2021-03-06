package chapter3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xdcao on 2017/4/1.
 */
@Repository
public class UserDao {

    private final static String MATCH_COUNT_SQL="select count(*) from t_user where user_name=? and password=?";
    private final static String UPDATE_LOGIN_INFO_SQL="update t_user set last_visit=?,last_ip=?,credit=? where user_id=?";
    private final static String FIND_USER_SQL="select * from t_user where user_name=? and password=?";
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    查找匹配的用户数
     */
    public int getMatchCount(String username,String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,new Object[]{username,password},Integer.class);
    }

    public User findUserByUserName(final String username,String password){
        final User user=new User();
        jdbcTemplate.query(FIND_USER_SQL, new Object[]{username,password}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(username);
                user.setCredits(rs.getInt("credit"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{user.getLastVisit(),
        user.getLastIp(),user.getCredits(),user.getUserId()});
    }


}
