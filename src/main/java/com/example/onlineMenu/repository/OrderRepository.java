package com.example.onlineMenu.repository;

import com.example.onlineMenu.documents.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
