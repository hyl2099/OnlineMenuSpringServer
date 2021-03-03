package com.example.onlineMenu.repository;

import com.example.onlineMenu.documents.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface MenuRepository extends CrudRepository<Menu, Long> {

}