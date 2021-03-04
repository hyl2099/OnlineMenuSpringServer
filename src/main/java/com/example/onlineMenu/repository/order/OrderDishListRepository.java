package com.example.onlineMenu.repository.order;

import com.example.onlineMenu.documents.order.OrderDishList;
import org.springframework.data.repository.CrudRepository;

public interface OrderDishListRepository extends CrudRepository<OrderDishList, Long> {

    public void deleteByOrderId(Long id);
}
