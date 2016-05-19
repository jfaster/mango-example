package org.jfaster.mango.example.mapping;

import com.google.common.base.MoreObjects;

import java.util.Date;

/**
 * @author ash
 */
public class MappingUser {

    private int id;
    private String name;
    private int userAge;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                .add("id", id)
                .add("name", name)
                .add("userAge", userAge)
                .add("updateTime", updateTime)
                .toString();
    }

}
