package com.example.onlineMenu.repository.menu;

import com.example.onlineMenu.documents.menu.MenuDishList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface MenuDishListRepository  extends CrudRepository<MenuDishList, Long> {
    @Modifying//更新查询
    @Transactional//开启事务
    @Query("update MenuDishList mdl set " +
            "mdl.name = ?1, mdl.pictureId = ?2, mdl.description = ?3, mdl.price = ?4, mdl.isInMenuOrAd = ?5, mdl.discountPrice = ?6 where mdl.id = ?7")
    void updateMenuDishList(String name, Long pictureId, String description, Float price, int isInMenuOrAd, Float discountPrice, Long id);


    //   JPA的查询语言,类似于sql
    //   里面不能出现表名,列名,只能出现java的类名,属性名，区分大小写
    //   出现的sql关键字是一样的意思,不区分大小写
    //   不能写select *  要写select 别名
    @Transactional//开启事务
    @Query("update MenuDishList mdl set " +
            "mdl.name = ?1, mdl.pictureId = ?2, mdl.description = ?3, mdl.price = ?4, mdl.isInMenuOrAd = ?5,  mdl.discountPrice = ?6, mdl.id = ?7 where mdl.isInMenuOrAd = 1")
    void findMenuDishList(String name, Long pictureId, String description, Float price, int isInMenuOrAd, Float discountPrice, Long id);
    //isInMenuOrAd 0为draft,1为在菜单上,2为既在菜单上又在广告上。
}
