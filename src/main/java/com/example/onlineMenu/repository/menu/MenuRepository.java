package com.example.onlineMenu.repository.menu;

import com.example.onlineMenu.documents.menu.Menu;
import com.example.onlineMenu.documents.menu.MenuDishList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Transactional//开启事务
    @Query("update MenuDishList mdl set " +
            "mdl.name = ?1, mdl.pictureId = ?2, mdl.description = ?3, mdl.price = ?4, mdl.isInMenuOrAd = ?5,  mdl.discountPrice = ?6, mdl.id = ?7 where mdl.isInMenuOrAd = 1")
    //isInMenuOrAd 0为draft,1为在菜单上,2为既在菜单上又在广告上。
    List<MenuDishList> findAllDishList(String name, Long pictureId, String description, Float price, int isInMenuOrAd, Float discountPrice, Long id);

    @Override
    Optional<Menu> findById(Long aLong);

}