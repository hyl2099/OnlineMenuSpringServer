package com.example.onlineMenu.repository;

import com.example.onlineMenu.documents.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface MenuRepository extends CrudRepository<Menu, Long> {

    @Modifying//更新查询
    @Transactional//开启事务
    @Query("update Menu m set m.remark = ?1 where m.id = ?2")
    void updatePictureRemark(String remark, Long id);


}