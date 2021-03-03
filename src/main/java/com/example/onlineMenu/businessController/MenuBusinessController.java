package com.example.onlineMenu.businessController;

import com.example.onlineMenu.documents.Menu;
import com.example.onlineMenu.repository.MenuRepository;
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

    public Optional<Menu> searchOrder(Long id){
        return this.menuRepository.findById(id);
    }

    public Menu saveMenu(Menu m){
        return this.menuRepository.save(m);
    }

    public void deleteMenu(Long id){
        this.menuRepository.deleteById(id);
    }
}
