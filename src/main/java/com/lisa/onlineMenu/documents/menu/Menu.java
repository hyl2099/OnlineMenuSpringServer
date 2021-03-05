package com.lisa.onlineMenu.documents.menu;

import javax.persistence.*;

@Entity
public class Menu {
    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public Menu(Menu m) {
        this.name = m.name;
    }
    public Menu() {
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
}
