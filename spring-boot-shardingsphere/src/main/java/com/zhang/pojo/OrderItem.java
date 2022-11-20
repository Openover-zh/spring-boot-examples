package com.zhang.pojo;

/**
 * @author zhangJiaHao
 * @date 2022/11/13 18:53
 */
public class OrderItem {
    private Integer id;

    private String name;

    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
