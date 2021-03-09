package com.lisa.onlineMenu.repository.menu;

import com.lisa.onlineMenu.documents.menu.MenuDishList;
import com.sun.jdi.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface MenuDishListRepository  extends CrudRepository<MenuDishList, Long> {
    @Modifying
    @Transactional//开启事务
    @Query(value = "update MenuDishList mdl set " +
            "mdl.menuId = ?1, mdl.name = ?2, mdl.pictureId = ?3, mdl.description = ?4, mdl.price = ?5, mdl.isInMenuOrAd = ?6, mdl.discountPrice = ?7 where mdl.id = ?8", nativeQuery = true)
    void updateMenuDishList(Long menuId, String name, Long pictureId, String description, Float price, int isInMenuOrAd, Float discountPrice, Long id);

    @Modifying
    @Transactional//开启事务
    @Query(value = "update MenuDishList mdl set " +
            "mdl.name = ?2, mdl.pictureId = ?3, mdl.description = ?4, mdl.price = ?5, mdl.isInMenuOrAd = ?6, mdl.discountPrice = ?7 where mdl.id = ?8 mdl.menuId = ?1", nativeQuery = true)
    void updateMenuDishListInOneMenu(Long menuId, String name, Long pictureId, String description, Float price, int isInMenuOrAd, Float discountPrice, Long dishId);

    //另一种写法
    @Modifying
    @Transactional//开启事务
    @Query(value = "update MenuDishList mdl set mdl.isInMenuOrAd = 2, mdl.discountPrice =:discountPrice where mdl.id =:id and mdl.menuId =:menuId", nativeQuery = true)
    void updateDishAD(@Param("discountPrice") Float discountPrice, @Param("id")Long id, @Param("menuId")Long menuId);


    @Modifying
    @Transactional//开启事务
    @Query(value = "update MenuDishList mdl set mdl.isInMenuOrAd = 1 where mdl.id =:id and mdl.menuId =:menuId", nativeQuery = true)
    void updateDishOnMenu(@Param("id")Long id, @Param("id")Long menuId);



    //   JPA的查询语言,类似于sql
    //   里面不能出现表名,列名,只能出现java的类名,属性名，区分大小写
    //   出现的sql关键字是一样的意思,不区分大小写
    //   不能写select *  要写select 别名
    @Transactional//开启事务
    @Query(value = "select mdl from MenuDishList mdl where mdl.menuId = ?1", nativeQuery = true)
    Iterable<MenuDishList> findAllDishList(Long menuId);

    @Transactional//开启事务
    @Query(value = "select mdl from MenuDishList mdl where mdl.isInMenuOrAd = 1 and mdl.menuId = ?1", nativeQuery = true)
    Iterable<MenuDishList> findOnMenuDishList(Long menuId);
    //isInMenuOrAd 0为draft,1为在菜单上,2为既在菜单上又在广告上。

    @Transactional//开启事务
    @Query(value = "select mdl from MenuDishList mdl where mdl.isInMenuOrAd = 2 and mdl.menuId = ?1", nativeQuery = true)
    Iterable<MenuDishList> findOnADDishList(Long menuId);

    @Transactional//开启事务
    @Query(value = "select mdl from MenuDishList mdl where mdl.name = ?1 and mdl.menuId = ?2", nativeQuery = true)
    Optional<MenuDishList> findByName(String dishName, Long menuId);

    @Transactional//开启事务
    @Query(value = "select mdl from MenuDishList mdl where mdl.discountPrice IS NOT NULL and mdl.menuId = ?1", nativeQuery = true)
    Optional<MenuDishList> searchDiscountDish(Long menuId);

    @Transactional
    @Query(value = "delete from MenuDishList mdl where mdl.dishId = ?1 and mdl.menuId = ?2", nativeQuery = true)
    Optional<MenuDishList> deleteDishInOneMenu(Long dishId, Long menuId);

    //某个菜单中添加一个菜
    @Modifying
    @Transactional
    @Query(value = "insert into MenuDishList mdl (menuId, name, pictureId,  description, price, isInMenuOrAd,  discountPrice) " +
            "VALUES (:menuId, :#{#d.name},:#{#d.pictureId},:#{#d.description},:#{#d.price},:#{#d.isInMenuOrAd},:#{#d.discountPrice})", nativeQuery = true)
    void addDishInOneMenu(@Param("menuId")Long menuId,  @Param("d") MenuDishList d);




}
