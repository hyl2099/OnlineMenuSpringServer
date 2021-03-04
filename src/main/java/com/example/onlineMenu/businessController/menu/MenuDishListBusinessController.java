package com.example.onlineMenu.businessController.menu;

import com.example.onlineMenu.documents.menu.MenuDishList;
import com.example.onlineMenu.repository.menu.MenuDishListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

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





    //查询菜单中所以的菜，包括draft


    //查询菜单中所有在菜单中的菜（not draft，即isInMenuOrAd =1）

    //查询菜单中所有在广告中的菜（not draft，即isInMenuOrAd =2）
}
