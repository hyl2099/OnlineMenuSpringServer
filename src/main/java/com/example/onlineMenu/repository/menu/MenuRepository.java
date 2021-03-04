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

    @Modifying
    @Transactional//开启事务
    @Query("update Menu m set m.name = ?2 where m.id = ?1")
    void updateMenuName(Long id, String name);

}