package com.example.onlineMenu.controller;

import com.example.onlineMenu.businessController.menu.MenuBusinessController;
import com.example.onlineMenu.businessController.menu.MenuDishListBusinessController;
import com.example.onlineMenu.documents.menu.Menu;
import com.example.onlineMenu.documents.menu.MenuDishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {
    private MenuBusinessController menuBusinessController;
    private MenuDishListBusinessController menuDishListBusinessController;

    @Autowired
    public MenuController(MenuBusinessController menuBusinessController, MenuDishListBusinessController menuDishListBusinessController) {
        this.menuBusinessController = menuBusinessController;
        this.menuDishListBusinessController = menuDishListBusinessController;
    }


    //如果只有一张菜单的话，menu只需要查询的操作，修改具体的菜品会修改MenuDishList
    @GetMapping("/menu")
    public Iterable<Menu> findAll(){
        return menuBusinessController.readAll();
    }



    //添加一个新菜
    // 设置路由
    @RequestMapping("/menu/dish/add")
//    @RequiresPermissions("order:info")//注解是用来权限验证的
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至menu对象
    public MenuDishList addDish(@RequestBody MenuDishList d) {
        // 打印加载的数据
        System.out.println(d);
        // 调用保存操作
        return menuDishListBusinessController.addDish(d);
    }


    //删除一个菜
    @DeleteMapping("/menu/dish/delete/{id}")
    public void deletePicture(@PathVariable Long id) {
        this.menuDishListBusinessController.deleteDish(id);
    }
    //修改菜的信息
    // @PutMapping 表明该方法只接收 put 请求.
    @PatchMapping("/menu/dish/update/{id}")
    public int updateDish(@PathVariable Long id,@RequestBody MenuDishList d){
        return this.menuDishListBusinessController.updateDish(id,d);
    }



}
