package com.example.onlineMenu.documents;

import java.util.Date;
import java.util.List;

public class OrderDishObject {
    private Long id;
    private String userWeChat;
    private String description; // 点菜描述，例如不要辣。。
    private Float order_price;
    private String actual_price;
    private String mobile;
    private Integer order_status;
    private Date add_time;
    private Date pay_time;
    private List<OrderDishList> dishes;

    public OrderDishObject(Long id,String userWeChat, String description, Float order_price, String actual_price, String mobile, Integer order_status, Date add_time, Date pay_time, List<OrderDishList> dishes) {
        this.id = id;
        this.userWeChat = userWeChat;
        this.description = description;
        this.order_price = order_price;
        this.actual_price = actual_price;
        this.mobile = mobile;
        this.order_status = order_status;
        this.add_time = add_time;
        this.pay_time = pay_time;
        this.dishes = dishes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserWeChat() {
        return userWeChat;
    }

    public void setUserWeChat(String userWeChat) {
        this.userWeChat = userWeChat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Float order_price) {
        this.order_price = order_price;
    }

    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public List<OrderDishList> getDishes() {
        return dishes;
    }

    public void setDishes(List<OrderDishList> dishes) {
        this.dishes = dishes;
    }
}
