package org.jfaster.mango.example.binding;

import com.google.common.base.MoreObjects;

/**
 * @author ash
 */
public class BindingUser {

    private int uid;

    private String name;

    private int age;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uid", uid)
                .add("name", name)
                .add("age", age)
                .toString();
    }
}
