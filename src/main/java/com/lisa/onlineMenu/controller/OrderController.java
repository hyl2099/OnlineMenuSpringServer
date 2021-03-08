package com.lisa.onlineMenu.controller;

import com.lisa.onlineMenu.businessController.order.OrderBusinessController;
import com.lisa.onlineMenu.businessController.order.OrderDishListBusinessController;
import com.lisa.onlineMenu.documents.order.Order;
import com.lisa.onlineMenu.documents.order.OrderDishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {
    private OrderDishListBusinessController orderDishListBusinessController;
    private OrderBusinessController orderBusinessController;

    @Autowired
    public OrderController(OrderDishListBusinessController orderDishListBusinessController,OrderBusinessController orderBusinessController) {
        this.orderDishListBusinessController = orderDishListBusinessController;
        this.orderBusinessController = orderBusinessController;
    }


    /************查询order************/
    @GetMapping("/order")
    public Iterable<Order> findAllMenu(){
        return orderBusinessController.readAll();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> findMenuById(@PathVariable Long id){
        return orderBusinessController.searchOrderById(id);
    }

    @RequestMapping("/order/add")
    public Order addOrder(@RequestBody Order o) {
        return orderBusinessController.addOrder(o);
    }

    //删除一个菜单
    @DeleteMapping("/order/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        this.orderBusinessController.deleteOrder(id);
    }

    //给一个order修改折扣和实际价格
    @PatchMapping("/order/update/{id}")
    public int updateOrderDiscountActualPrice(@PathVariable Long id, @RequestBody Order o){
        int flag1 = this.orderBusinessController.updateOrderDiscount(id,o.getOrder_discount());
        int flag2 = this.orderBusinessController.updateOrderActualPrice(id,o.getActual_price());
        if(flag1==1 && flag2==1){
            return 1;
        }else return 0;
    }

    /************查询order************/


    /************查询一个order中具体点的菜************/
    //查看某一id的order中所有点的菜
    @GetMapping("/order/{id}/allDish")
    public Optional<OrderDishList> findAllDishInOneMenu(Long id){
        return orderDishListBusinessController.findAllDishInOneMenu(id);
    }


    /************查询一个order中具体点的菜************/




}
