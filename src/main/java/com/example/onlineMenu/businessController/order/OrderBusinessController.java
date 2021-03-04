package com.example.onlineMenu.businessController.order;

import com.example.onlineMenu.documents.order.Order;
import com.example.onlineMenu.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderBusinessController {
    private OrderRepository orderRepository;

    //自动装入
    @Autowired
    public OrderBusinessController( OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Iterable<Order> readAll(){
        return this.orderRepository.findAll();
    }

    public Optional<Order> searchOrder(Long id){
        return this.orderRepository.findById(id);
    }

    public Order saveOrder(Order o){
        return this.orderRepository.save(o);
    }


    public void deleteOrder (Long id){
        this.orderRepository.deleteById(id);
    }


}
