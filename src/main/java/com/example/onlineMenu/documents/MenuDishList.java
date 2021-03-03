package com.example.onlineMenu.documents;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MenuDishList {
    //    声明主键
    @Id
    //    声明主键生成策略为 自动
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 25)    // 声明字段的长度为25
    private String name;    // 菜名
    @Column(length = 50)
    private Long pictureId;   // 图片ID
    private String description; // 菜品描述
    private Float price;
    private boolean isInMenu;//是否上菜单，true为在菜单上，0为draft
    private boolean isInAD;//是否上广告，true为上主页面广告，0为draft
    private Float discountPrice;//打折价钱

    public MenuDishList(String name, Long pictureId, String description, Float price, boolean isInMenu, boolean isInAD, Float discountPrice) {
        this.name = name;
        this.pictureId = pictureId;
        this.description = description;
        this.price = price;
        this.isInMenu = isInMenu;
        this.isInAD = isInAD;
        this.discountPrice = discountPrice;
    }

    public MenuDishList(MenuDishList m) {
        this.name = m.name;
        this.pictureId = m.pictureId;
        this.description = m.description;
        this.price = m.price;
        this.isInMenu = m.isInMenu;
        this.isInAD = m.isInAD;
        this.discountPrice = m.discountPrice;
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

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public boolean isInMenu() {
        return isInMenu;
    }

    public void setInMenu(boolean inMenu) {
        isInMenu = inMenu;
    }

    public boolean isInAD() {
        return isInAD;
    }

    public void setInAD(boolean inAD) {
        isInAD = inAD;
    }

    public Float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Float discountPrice) {
        this.discountPrice = discountPrice;
    }
}
