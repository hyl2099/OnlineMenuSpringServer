package com.example.onlineMenu.businessController.menu;

import com.example.onlineMenu.documents.menu.MenuDishList;
import com.example.onlineMenu.repository.menu.MenuDishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class MenuDishListBusinessController {
    private MenuDishListRepository menuDishListRepository;

    //自动装入
    @Autowired
    public MenuDishListBusinessController( MenuDishListRepository menuDishListRepository) {
        this.menuDishListRepository = menuDishListRepository;
    }

    //菜单中加一个菜
    public MenuDishList addDish(MenuDishList d){
        return this.menuDishListRepository.save(d);
    }

    //菜单中删除一个菜
    public void deleteDish(Long id){
        this.menuDishListRepository.deleteById(id);
    }

    //菜单中修改一个菜
    public int  updateDish(Long id, MenuDishList dish) {
        if (menuDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + dish.getId().toString() + "Wrong, no entity.");
        }
        else {
            this.menuDishListRepository.updateMenuDishList(
                    dish.getMenuId(), dish.getName(), dish.getPictureId(),dish.getDescription(), dish.getPrice(), dish.getIsInMenuOrAd(), dish.getDiscountPrice(), id);
            return 1;
        }
    }

    //修改一个菜是否上广告，并修改折扣价
    public int  updateDishAD(Long id, MenuDishList dish) {
        if (menuDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + dish.getId().toString() + "Wrong, no entity.");
        }
        else {
            this.menuDishListRepository.updateDishAD(dish.getDiscountPrice(), id);
            return 1;
        }
    }

    //修改一个菜是否上菜单
    public int  updateDishOnMenu(Long id, MenuDishList dish) {
        if (menuDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + dish.getId().toString() + "Wrong, no entity.");
        }
        else {
            this.menuDishListRepository.updateDishOnMenu(id);
            return 1;
        }
    }

    //查询菜单中所以的菜，包括draft
    //迭代器(Iterator)主要用来操作java里的集合对象(collection)。迭代器提供了统一的语法进行集合对象(collection)遍历操作，无需关心集合对象的内部实现方式。
    public Iterable<MenuDishList> findAllDish(MenuDishList d){
        return this.menuDishListRepository.findAll();
    }

    //按菜名查询某个菜
    public Optional<MenuDishList> searchDishByName(String dishName){
        return this.menuDishListRepository.findByName(dishName);
    }

    //查询打折的菜
    public Optional<MenuDishList> searchDiscountDish(){
        return this.menuDishListRepository.searchDiscountDish();
    }

    //查询菜单中所有在菜单中的菜（not draft，即isInMenuOrAd =1）
    public Iterable<MenuDishList> findAllMenuDish(MenuDishList d){
        return this.menuDishListRepository.findOnMenuDishList();
    }

    //查询菜单中所有在广告中的菜（not draft，即isInMenuOrAd =2）
    public Iterable<MenuDishList> findAllADDish(MenuDishList d){
        return this.menuDishListRepository.findOnADDishList();
    }

}
