package com.example.onlineMenu.documents;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Order {

    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userWeChat;
    @Column(length = 100)    // 声明字段的长度为100
    private String description; // 点菜描述，例如不要辣。。
    private Float order_price;
    private String actual_price;
    private String mobile;
    private Integer order_status;
    private Date add_time;
    private Date pay_time;

}
