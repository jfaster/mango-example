package org.jfaster.mango.example.sharding;

import com.google.common.base.MoreObjects;

/**
 * @author ash
 */
public class Order {

    private String id;

    private int uid;

    private int price;

    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("uid", uid)
                .add("price", price)
                .add("status", status)
                .toString();
    }

}
