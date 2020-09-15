package com.example.onlineMenu.Controller;

import com.example.onlineMenu.documents.Menu;
import com.example.onlineMenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    // 设置路由
    @RequestMapping("/teacher/save")
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至teacher对象
    public Menu saveTeacher(@RequestBody Menu menu) {
        // 打印加载的数据
        System.out.println(menu);
        // 调用保存操作
        return menuRepository.save(menu);
    }


}
