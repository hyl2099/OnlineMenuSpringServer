package com.example.onlineMenu.repository;

import com.example.onlineMenu.documents.MenuDishList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface MenuDishListRepository  extends CrudRepository<MenuDishList, Long> {
    @Modifying//更新查询
    @Transactional//开启事务
    @Query("update MenuDishList mdl set " +
            "mdl.name = ?1, mdl.pictureId = ?2, mdl.description = ?3, mdl.price = ?4, mdl.isInMenu = ?5, mdl.isInAD = ?6, mdl.discountPrice = ?7 where mdl.id = ?8")
    void updateMenuDishList(String name, Long pictureId,String description,Float price,boolean isInMenu,boolean isInAD,Float discountPrice, Long id);

}
