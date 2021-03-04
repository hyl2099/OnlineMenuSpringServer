package com.example.onlineMenu.businessController.menu;

import com.example.onlineMenu.documents.menu.Menu;
import com.example.onlineMenu.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MenuBusinessController {
    private MenuRepository menuRepository;

    //自动装入
    @Autowired
    public MenuBusinessController( MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    public Iterable<Menu> readAll(){
        return this.menuRepository.findAll();
    }


    //如果只有一个默认menu的话以下都不需要
    public Optional<Menu> searchMenu(Long id){
        return this.menuRepository.findById(id);
    }

    public Menu saveMenu(Menu m){
        return this.menuRepository.save(m);
    }

    public void deleteMenu(Long id){
        this.menuRepository.deleteById(id);
    }
}
