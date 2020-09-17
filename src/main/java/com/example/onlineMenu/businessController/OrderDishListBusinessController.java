package com.example.onlineMenu.businessController;

import com.example.onlineMenu.documents.Order;
import com.example.onlineMenu.documents.OrderDishList;
import com.example.onlineMenu.repository.OrderDishListRepository;
import com.example.onlineMenu.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
