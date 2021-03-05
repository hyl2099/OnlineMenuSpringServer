package com.lisa.onlineMenu.businessController.order;

import com.lisa.onlineMenu.documents.order.Order;
import com.lisa.onlineMenu.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Optional;

public class OrderBusinessController {
    private OrderRepository orderRepository;

    //自动装入
    @Autowired
    public OrderBusinessController( OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    /***Oder基本操作***/

    public Iterable<Order> readAll(){
        return this.orderRepository.findAll();
    }

    public Optional<Order> searchOrderById(Long id){
        return this.orderRepository.findById(id);
    }

    public Order addOrder(Order o){
        return this.orderRepository.save(o);
    }

    public Integer updateOrder(Long id, Order o){
        if (orderRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderRepository.updateOrder(id,o);
            return 1;
        }
    }

    public void deleteOrder (Long id){
        this.orderRepository.deleteById(id);
    }

    //修改实际价格
    public Integer updateOrderActualPrice(Long id, Float actual_price){
        if (orderRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderRepository.updateOrderActualPrice(id, actual_price);
            return 1;
        }
    }

    //修改订单状态
    public Integer updateOrderStatus(Long id, Integer order_status){
        if (orderRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderRepository.updateOrderStatus(id, order_status);
            return 1;
        }
    }

    //修改折扣
    public Integer updateOrderDiscount(Long id, Float order_discount){
        if (orderRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderRepository.updateOrderDiscount(id, order_discount);
            return 1;
        }
    }

    //修改折扣
    public Integer updateOrderAddTime(Long id, Date add_time){
        if (orderRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderRepository.updateOrderAddTime(id, add_time);
            return 1;
        }
    }


    //修改折扣
    public Integer updateOrderPayTime(Long id, Date pay_time){
        if (orderRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderRepository.updateOrderPayTime(id, pay_time);
            return 1;
        }
    }



    /***Oder基本操作***/



}
