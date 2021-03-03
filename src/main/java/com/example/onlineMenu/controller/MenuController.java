package com.example.onlineMenu.controller;

import com.example.onlineMenu.businessController.MenuBusinessController;
import com.example.onlineMenu.documents.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {
    private MenuBusinessController menuBusinessController;

    @Autowired
    public MenuController(MenuBusinessController menuBusinessController) {
        this.menuBusinessController = menuBusinessController;
    }

    // 设置路由
    @RequestMapping("/menu/save")
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至teacher对象
    public Menu saveMenu(@RequestBody Menu menu) {
        // 打印加载的数据
        System.out.println(menu);
        // 调用保存操作
        return menuBusinessController.saveMenu(menu);
    }

    @GetMapping("/menu/all")
    public Iterable<Menu> findAll(){
        return menuBusinessController.readAll();
    }



}
