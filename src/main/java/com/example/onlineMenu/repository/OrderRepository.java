package com.example.onlineMenu.repository;

import com.example.onlineMenu.documents.Order;
import com.example.onlineMenu.documents.OrderDishList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query(value = "SELECT o.id, o.userWeChat, o.description, o.order_price, o.actual_price, o.mobile, o.order_status, o.add_time, o.pay_time, FROM Order o, OrderDishList od WHERE o.id = od.orderId")
    public List<OrderDishList> findOrderDish();
}
