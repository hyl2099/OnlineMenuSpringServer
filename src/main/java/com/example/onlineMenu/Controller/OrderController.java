package com.example.onlineMenu.Controller;

import com.example.onlineMenu.businessController.OrderBusinessController;
import com.example.onlineMenu.businessController.OrderDishListBusinessController;
import com.example.onlineMenu.documents.Order;
import com.example.onlineMenu.documents.OrderDishList;
import com.example.onlineMenu.documents.OrderDishObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class OrderController {
    private OrderDishListBusinessController orderDishListBusinessController;
    private OrderBusinessController orderBusinessController;

    @Autowired
    public OrderController(OrderDishListBusinessController orderDishListBusinessController,OrderBusinessController orderBusinessController) {
        this.orderDishListBusinessController = orderDishListBusinessController;
        this.orderBusinessController = orderBusinessController;
    }


    @RequestMapping("/order/add")
    public void addOrder(@RequestBody OrderDishObject orderDishes) {
        //分两步，
        //1，把传过来的list拆出来，选出order相关信息写进order表
        //2，选出具体点菜的dish的写进OrderDishList
        Order o = new Order(orderDishes.getUserWeChat(),orderDishes.getDescription(),orderDishes.getOrder_price(),
                orderDishes.getActual_price(),orderDishes.getMobile(),orderDishes.getOrder_status(),orderDishes.getAdd_time(),orderDishes.getPay_time());
        orderBusinessController.saveOrder(o);
        for(int i = 0; i<= orderDishes.getDishes().size();i++){
            OrderDishList dish = orderDishes.getDishes().get(i);
            this.orderDishListBusinessController.saveDish(dish);
        }
    }


    @GetMapping("/order/all")
    public Iterable<OrderDishObject> readAll(){
//        orderBusinessController.readAll();
        return null;

    }

    @DeleteMapping("/order/delete/{id}")
    public void deleteTemperature(@PathVariable Long id) {
        this.orderBusinessController.deleteOrder(id);
        this.orderDishListBusinessController.deleteByOrderId(id);
    }



}
