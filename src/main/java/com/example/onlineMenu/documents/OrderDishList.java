package com.example.onlineMenu.documents;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class OrderDishList {
    @Id
    @GeneratedValue
    private Long id;
    private Long orderId;
    private Long dishId;
    private String dishName;
    private Float dishPrice;
    private String clientWechat;
    private Integer isServed;
    private Date add_time;

    public OrderDishList(Long orderId, Long dishId, String dishName, Float dishPrice, String clientWechat, Integer isServed, Date add_time) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.clientWechat = clientWechat;
        this.isServed = isServed;
        this.add_time = add_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getClientWechat() {
        return clientWechat;
    }

    public void setClientWechat(String clientWechat) {
        this.clientWechat = clientWechat;
    }

    public Integer getIsServed() {
        return isServed;
    }

    public void setIsServed(Integer isServed) {
        this.isServed = isServed;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }
}
