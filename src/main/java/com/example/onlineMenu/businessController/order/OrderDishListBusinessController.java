package com.example.onlineMenu.businessController.order;

import com.example.onlineMenu.documents.order.OrderDishList;
import com.example.onlineMenu.repository.order.OrderDishListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderDishListBusinessController {
    private OrderDishListRepository orderDishListRepository;

    //自动装入
    @Autowired
    public OrderDishListBusinessController(OrderDishListRepository orderDishListRepository) {
        this.orderDishListRepository = orderDishListRepository;
    }

    public Iterable<OrderDishList> readAll(){
        return this.orderDishListRepository.findAll();
    }

    public Optional<OrderDishList> searchDish(Long id){
        return this.orderDishListRepository.findById(id);
    }

    public OrderDishList saveDish(OrderDishList o){
        return this.orderDishListRepository.save(o);
    }

    public void deleteByOrderId (Long id){
        this.orderDishListRepository.deleteByOrderId(id);
    }

    public void deleteById (Long id){
        this.orderDishListRepository.deleteById(id);
    }

}
