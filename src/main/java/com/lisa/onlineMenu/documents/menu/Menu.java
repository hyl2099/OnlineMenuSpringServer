package com.lisa.onlineMenu.documents.menu;

import javax.persistence.*;

@Entity
public class Menu {
    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String name;


    public Menu(Long userId, String name) {
        this.name = name;
        this.userId = userId;
    }

    public Menu(Menu m){
        this.name = m.name;
        this.userId = m.userId;
    }

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
