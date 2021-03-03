package com.example.onlineMenu.documents;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {
    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<MenuDishList> dishList;

    public Menu(List<MenuDishList> dishList) {
        this.dishList=dishList;
    }

    public Menu() {
    }

    public Menu(Menu m) {
        this.dishList = m.dishList;
    }

    public Long getId() {
        return id;
    }

    public List<MenuDishList> getDishList() {
        return dishList;
    }

    public void setDishList(List<MenuDishList> dishList) {
        this.dishList = dishList;
    }
}
