package com.example.onlineMenu.businessController.menu;

import com.example.onlineMenu.documents.menu.MenuDishList;
import com.example.onlineMenu.repository.menu.MenuDishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class MenuDishListBusinessController {
    private MenuDishListRepository menuDishListRepository;

    ////针对菜对象
    //自动装入
    @Autowired
    public MenuDishListBusinessController( MenuDishListRepository menuDishListRepository) {
        this.menuDishListRepository = menuDishListRepository;
    }

    //查询所有的菜，不管在哪个菜单
    public Iterable<MenuDishList> findAll(){
        return this.menuDishListRepository.findAll();
    }

    //加一个菜
    public MenuDishList addDish(MenuDishList d){
        return this.menuDishListRepository.save(d);
    }

    //删除一个菜
    public void deleteDish(Long id){
        this.menuDishListRepository.deleteById(id);
    }



    //针对某个菜单中的菜对象
    //查询某ID的菜单中所有的菜，包括draft
    public Iterable<MenuDishList> findAllDishInOneMenu(Long menuId){
        return this.menuDishListRepository.findAllDishList(menuId);
    }

    //查询某ID的菜单中所有在菜单中的菜，不包括draft（not draft，即isInMenuOrAd =1）
    public Iterable<MenuDishList> findAllMenuDishInOneMenu(Long menuId){
        return this.menuDishListRepository.findOnMenuDishList(menuId);
    }

    //查询某ID的菜单中所有在广告中的菜（not draft，即isInMenuOrAd =2）
    public Iterable<MenuDishList> findAllADDishInOneMenu(Long menuId){
        return this.menuDishListRepository.findOnADDishList(menuId);
    }

    //迭代器(Iterator)主要用来操作java里的集合对象(collection)。迭代器提供了统一的语法进行集合对象(collection)遍历操作，无需关心集合对象的内部实现方式。

    //某ID的菜单中按菜名查询某个菜
    public Optional<MenuDishList> searchDishByNameInOneMenu(String dishName, Long menuId){
        return this.menuDishListRepository.findByName(dishName,menuId);
    }

    //某ID的菜单中查询打折的菜
    public Optional<MenuDishList> searchDiscountDishInOneMenu(Long menuId){
        return this.menuDishListRepository.searchDiscountDish(menuId);
    }

    //某ID的菜单中修改一个菜是否上广告，并修改折扣价
    public int  updateDishADInOneMenu(Long id, MenuDishList dish, Long menuId) {
        if (menuDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + dish.getId().toString() + "Wrong, no entity.");
        }
        else {
            this.menuDishListRepository.updateDishAD(dish.getDiscountPrice(), id, menuId);
            return 1;
        }
    }

    //修改某菜单中一个菜的信息
    public int  updateDish(Long menuId, Long dishId, MenuDishList dish) {
        if (menuDishListRepository.findById(dishId) == null)
        {
            throw new EntityNotFoundException("the id :" + dishId.toString() + "Wrong, no entity.");
        }
        else {
            this.menuDishListRepository.updateMenuDishList(
                    menuId, dish.getName(), dish.getPictureId(),dish.getDescription(), dish.getPrice(), dish.getIsInMenuOrAd(), dish.getDiscountPrice(), dishId);
            return 1;
        }
    }

    //某ID的菜单中修改一个菜是否上菜单
    public int  updateDishOnMenuInOneMenu(Long id, Long menuId) {
        if (menuDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.menuDishListRepository.updateDishOnMenu(id, menuId);
            return 1;
        }
    }

    //某ID的菜单中删除一个菜
    public void deleteDishInOneMenu(Long dishId,Long menuId){
        this.menuDishListRepository.deleteDishInOneMenu(dishId,menuId);
    }



}
