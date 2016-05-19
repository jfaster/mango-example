package org.jfaster.mango.example.mapping;

import com.google.common.base.MoreObjects;

import java.util.Date;

/**
 * @author ash
 */
public class MappingUser2 {

    private int userId;
    private String userName;
    private int userAge;
    private Date updateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("userId", userId)
                .add("userName", userName)
                .add("userAge", userAge)
                .add("updateTime", updateTime)
                .toString();
    }

}
