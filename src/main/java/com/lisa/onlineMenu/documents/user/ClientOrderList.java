package com.lisa.onlineMenu.documents.user;

import javax.persistence.*;

@Entity
public class ClientOrderList {
    //用户一共点过的order的表
    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 25)
    private Long orderId;
    private Long clientUserId;

    public ClientOrderList(Long orderId, Long clientUserId) {
        this.orderId = orderId;
        this.clientUserId = clientUserId;
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

    public Long getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(Long clientUserId) {
        this.clientUserId = clientUserId;
    }
}
