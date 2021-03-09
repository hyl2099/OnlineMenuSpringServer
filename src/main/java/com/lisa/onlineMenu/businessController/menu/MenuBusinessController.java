package com.lisa.onlineMenu.businessController.menu;

import com.lisa.onlineMenu.documents.menu.Menu;
import com.lisa.onlineMenu.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Controller
public class MenuBusinessController {
    private MenuRepository menuRepository;

    //自动装入
    @Autowired
    public MenuBusinessController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    public Iterable<Menu> readAll(){
        return this.menuRepository.findAll();
    }

    //如果只有一个默认menu的话以下都不需要
    public Optional<Menu> findById(Long id){
        return this.menuRepository.findById(id);
    }

    public int updateMenuName(Long id, String name){
        if (menuRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.menuRepository.updateMenuName(id,name);
            return 1;
        }
    }

    public Menu saveMenu(Menu m){
        return this.menuRepository.save(m);
    }

    public void deleteMenu(Long id){
        this.menuRepository.deleteById(id);
    }
}
