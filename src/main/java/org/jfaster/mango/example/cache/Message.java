package org.jfaster.mango.example.cache;

import com.google.common.base.MoreObjects;

public class Message {

    private int id;
    private int uid;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("uid", uid)
                .add("content", content)
                .toString();
    }

}
