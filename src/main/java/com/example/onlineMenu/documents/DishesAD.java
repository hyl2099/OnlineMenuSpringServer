package com.example.onlineMenu.documents;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DishesAD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long dishID;
    private String description; // 菜品描述
    private Float actualPrice; //打折菜价

    public DishesAD(Long dishID, String description, Float actualPrice) {
        this.dishID = dishID;
        this.description = description;
        this.actualPrice = actualPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishID() {
        return dishID;
    }

    public void setDishID(Long dishID) {
        this.dishID = dishID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Float actualPrice) {
        this.actualPrice = actualPrice;
    }
}
