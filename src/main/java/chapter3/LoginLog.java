package chapter3;

import java.util.Date;

/**
 * Created by xdcao on 2017/4/1.
 */
public class LoginLog {

    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getLoginLogId() {

        return loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public String getIp() {
        return ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }
}
