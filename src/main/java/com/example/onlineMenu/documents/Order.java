package com.example.onlineMenu.documents;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class Order {

    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userWeChat;
    @Column(length = 100)    // 声明字段的长度为100
    private String description; // 点菜描述，例如不要辣。。
    private List<OrderDishList> order_dishList;
    private Float order_discount;
    private Float order_price;
    private String actual_price;
    private String mobile;
    private Integer order_status;
    private Date add_time;
    private Date pay_time;

    public Order(String userWeChat, String description, Float order_price, String actual_price, String mobile, Integer order_status, Date add_time, Date pay_time) {
        this.userWeChat = userWeChat;
        this.description = description;
        this.order_price = order_price;
        this.actual_price = actual_price;
        this.mobile = mobile;
        this.order_status = order_status;
        this.add_time = add_time;
        this.pay_time = pay_time;
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
}
