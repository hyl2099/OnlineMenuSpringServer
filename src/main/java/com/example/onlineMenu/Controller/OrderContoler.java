package com.example.onlineMenu.Controller;

import com.example.onlineMenu.documents.Menu;
import com.example.onlineMenu.documents.Order;
import com.example.onlineMenu.repository.MenuRepository;
import com.example.onlineMenu.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class OrderContoler {
    @Autowired
    private OrderRepository orderRepository;

    // 设置路由
    @RequestMapping("/teacher/save")
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至teacher对象
    public Order saveTeacher(@RequestBody Order order) {
        // 打印加载的数据
        System.out.println(order);
        // 调用保存操作
        return orderRepository.save(order);
    }

}
