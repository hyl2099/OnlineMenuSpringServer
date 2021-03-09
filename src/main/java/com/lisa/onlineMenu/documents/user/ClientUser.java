package com.lisa.onlineMenu.documents.user;

import javax.persistence.*;

@Entity
public class ClientUser {
    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 25)    // 声明字段的长度为25
    private String name;    // 用户名
    private String userWechat;
    private String description; // 客人备注
    private String mobile;

    public ClientUser(String name, String userWechat, String description, String mobile) {
        this.name = name;
        this.userWechat = userWechat;
        this.description = description;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
