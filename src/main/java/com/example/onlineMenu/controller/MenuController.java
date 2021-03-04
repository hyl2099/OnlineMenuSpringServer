package com.example.onlineMenu.controller;

import com.example.onlineMenu.businessController.menu.MenuBusinessController;
import com.example.onlineMenu.businessController.menu.MenuDishListBusinessController;
import com.example.onlineMenu.documents.menu.Menu;
import com.example.onlineMenu.documents.menu.MenuDishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MenuController {
    private MenuBusinessController menuBusinessController;
    private MenuDishListBusinessController menuDishListBusinessController;

    @Autowired
    public MenuController(MenuBusinessController menuBusinessController, MenuDishListBusinessController menuDishListBusinessController) {
        this.menuBusinessController = menuBusinessController;
        this.menuDishListBusinessController = menuDishListBusinessController;
    }

    /********menu整体操作********/
    //如果只有一张菜单的话，menu只需要查询的操作，修改具体的菜品会修改MenuDishList
    //查询所有菜单
    @GetMapping("/menu")
    public Iterable<Menu> findAllMenu(){
        return menuBusinessController.readAll();
    }

    //查询一个菜单
    @GetMapping("/menu/{id}")
    public Optional<Menu> findMenuById(@PathVariable Long id){
        return menuBusinessController.findById(id);
    }
    //增加一个新菜单
    @RequestMapping("/menu/add")
    public Menu addDish(@RequestBody Menu m) {
        return menuBusinessController.saveMenu(m);
    }

    //删除一个菜单
    @DeleteMapping("/menu/delete/{id}")
    public void deleteMenu(@PathVariable Long id) {
        this.menuBusinessController.deleteMenu(id);
    }

    //给一个菜单改名
    @PatchMapping("/menu/update/{id}")
    public int updateDish(@PathVariable Long id, @RequestBody Menu m){
        return this.menuBusinessController.updateMenuName(id, m.getName());
    }
    /********menu整体操作********/


    /********具体某一个menu操作********/
    //查看某一id的菜单中所有菜
    @GetMapping("/menu/{id}/allDish")
    public Iterable<MenuDishList> findAllDishInOneMenu(Long id){
        return menuDishListBusinessController.findAllDishInOneMenu(id);
    }

    //查看某一id的菜单中所有上了菜单的菜
    @GetMapping("/menu/{id}/allMenuDish")
    public Iterable<MenuDishList> findAllMenuDishInOneMenu(Long id){
        return menuDishListBusinessController.findAllMenuDishInOneMenu(id);
    }

    //查看某一id的菜单中所有上了广告的菜（折扣）
    @GetMapping("/menu/{id}/allMenuDish")
    public Iterable<MenuDishList> findAllADDishInOneMenu(Long id){
        return menuDishListBusinessController.findAllADDishInOneMenu(id);
    }


    //某菜单添加一个新菜
    @RequestMapping("/menu/{id}/dish/add")
    // @RequiresPermissions("order:info")//注解是用来权限验证的
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至menu对象
    public MenuDishList addDish(@RequestParam Long id,@RequestBody MenuDishList d) {
        d.setMenuId(id);
        return menuDishListBusinessController.addDish(d);
    }

    //删除某个菜单中一个菜
    @DeleteMapping("/menu/{menuId}dish/delete/{dishId}")
    public void deletePicture(@PathVariable Long menuId,@PathVariable Long dishId) {
        this.menuDishListBusinessController.deleteDishInOneMenu(dishId,menuId);
    }

    //修改某个菜单中一个菜的信息
    // @PutMapping 表明该方法只接收 put 请求.
    @PatchMapping("/menu/{menuId}/dish/update/{dishId}")
    public int updateDish(@PathVariable Long menuId, @PathVariable Long dishId,@RequestBody MenuDishList d){
        return this.menuDishListBusinessController.updateDish(menuId,dishId,d);
    }

    /********具体某一个menu操作********/

}
