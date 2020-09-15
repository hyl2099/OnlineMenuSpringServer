package com.example.demo.repository;

import javax.persistence.*;

@Entity
public class Menu {
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

    public Menu(String name, Long pictureId, String description, Float price) {
        this.name = name;
        this.pictureId = pictureId;
        this.description = description;
        this.price = price;
    }

    public Menu() {
    }

    public Menu(Menu m) {
        this.name = m.name;
        this.pictureId = m.pictureId;
        this.description = m.description;
        this.price = m.price;
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
}
