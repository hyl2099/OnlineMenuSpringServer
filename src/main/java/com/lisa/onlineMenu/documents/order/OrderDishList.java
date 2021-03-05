package com.lisa.onlineMenu.documents.order;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class OrderDishList {
    @Id
    @GeneratedValue
    private Long id;
    private Long orderId;
    private Long dishId;//menuDishList 中的ID
    private String dishName;
    private Float dishPrice;
    private Float actual_price;
    private String clientWechat;
    //是否上菜
    private Integer isServed;
    private Date add_time;
    //上菜时间
    private Date serve_time;

    public OrderDishList(Long orderId, Long dishId, String dishName, Float dishPrice, Float actual_price,
                         String clientWechat, Integer isServed, Date add_time, Date serve_time) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.actual_price = actual_price;
        this.clientWechat = clientWechat;
        this.isServed = isServed;
        this.add_time = add_time;
        this.serve_time = serve_time;
    }

    public OrderDishList(OrderDishList o) {
        this.orderId = o.orderId;
        this.dishId = o.dishId;
        this.dishName = o.dishName;
        this.dishPrice = o.dishPrice;
        this.actual_price = o.actual_price;
        this.clientWechat = o.clientWechat;
        this.isServed = o.isServed;
        this.add_time = o.add_time;
        this.serve_time = o.serve_time;
    }


    public Long getId() {
        return id;
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

    public Float getActual_price() {
        return actual_price;
    }

    public void setActual_price(Float actual_price) {
        this.actual_price = actual_price;
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

    public Date getServe_time() {
        return serve_time;
    }

    public void setServe_time(Date serve_time) {
        this.serve_time = serve_time;
    }
}
