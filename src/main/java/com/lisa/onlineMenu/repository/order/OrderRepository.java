package com.lisa.onlineMenu.repository.order;

import com.lisa.onlineMenu.documents.order.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

public interface OrderRepository extends CrudRepository<Order, Long> {

    //修改付款价格
    @Modifying
    @Transactional//开启事务
    @Query("update Order o set o.actual_price = :actual_price where m.id = :id")
    void updateOrderActualPrice(@Param("id")Long id, @Param("actual_price") Float actual_price);

    //修改status
    @Modifying
    @Transactional//开启事务
    @Query("update Order o set o.order_discount = :order_discount where m.id = :id")
    void updateOrderDiscount(@Param("id")Long id, @Param("order_discount") Float order_discount);

    //整体修改
    @Modifying
    @Transactional
    @Query("update Order o set o.userWeChat = :#{#o.userWeChat},o.description =:#{#o.description}," +
            "o.order_discount=:#{#o.order_discount},o.order_price =:#{#o.order_price},o.actual_price =:#{#o.actual_price}," +
            "o.mobile =:#{#o.mobile}, o.order_status =:#{#o.order_status},o.add_time =:#{#o.add_time},o.pay_time =:#{#o.pay_time} where o.id=:#{#id}")
    void updateOrder(@Param("id")Long id, @Param("o") Order o);

    //修改status
    @Modifying
    @Transactional//开启事务
    @Query("update Order o set o.order_status = :order_status where m.id = :id")
    void updateOrderStatus(@Param("id")Long id, @Param("order_status") Integer order_status);


    //修改add_time
    @Modifying
    @Transactional//开启事务
    @Query("update Order o set o.add_time = :add_time where m.id = :id")
    void updateOrderAddTime(@Param("id")Long id, @Param("add_time") Date add_time);

    //修改pay_time
    @Modifying
    @Transactional//开启事务
    @Query("update Order o set o.pay_time = :pay_time where m.id = :id")
    void updateOrderPayTime(@Param("id")Long id, @Param("pay_time") Date pay_time);



}
