package com.lisa.onlineMenu.repository.menu;

import com.lisa.onlineMenu.documents.menu.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Modifying
    @Transactional//开启事务
    @Query(value = "update Menu m set m.name = ?2 where m.id = ?1", nativeQuery = true)
    void updateMenuName(Long id, String name);

}