package com.example.onlineMenu.repository.order;

import com.example.onlineMenu.documents.menu.MenuDishList;
import com.example.onlineMenu.documents.order.OrderDishList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

public interface OrderDishListRepository extends CrudRepository<OrderDishList, Long> {
    ////////////整体修改
    @Modifying
    @Transactional
    @Query("update OrderDishList o set o.orderId = :#{#o.orderId},o.dishId =:#{#o.dishId}," +
            "o.dishName=:#{#o.dishName},o.dishPrice =:#{#o.dishPrice},o.actual_price =:#{#o.actual_price}," +
            "o.clientWechat =:#{#o.clientWechat}, o.isServed =:#{#o.isServed},o.add_time =:#{#o.add_time},o.serve_time =:#{#o.serve_time} where o.id=:id")
    void updateOrderDish(@Param("id")Long id, @Param("o") OrderDishList o);

    @Transactional
    @Query("select o from OrderDishList o where o.name = ?1")
    Optional<OrderDishList> findByName(String name);

    //修改是否上菜
    @Modifying
    @Transactional//开启事务
    @Query("update OrderDishList o set o.isServed = :isServed where m.id = :id")
    void updateOrderDishStatus(@Param("id")Long id, @Param("isServed") Integer isServed);

    //修改serve_time
    @Modifying
    @Transactional//开启事务
    @Query("update OrderDishList o set o.serve_time = :serve_time where m.id = :id")
    void updateOrderDishServeTime(@Param("id")Long id, @Param("serve_time") Date serve_time);


    //修改actual_price
    @Modifying
    @Transactional//开启事务
    @Query("update OrderDishList o set o.actual_price = :actual_price where m.id = :id")
    void updateOrderDishActualPrice(@Param("id")Long id, @Param("actual_price")Float actual_price);




    ///////////////////针对某个order中一个菜
    //查找改order中的所有菜
    @Transactional
    @Query("select o from OrderDishList o where o.orderId = ?1")
    Optional<OrderDishList> searchDiscountDish(Long orderId);

    @Transactional
    @Query("select o from OrderDishList o where o.orderId = ?1 and o.id = ?2")
    Optional<OrderDishList> searchDiscountDish(Long orderId, Long orderDishId);

    //某个菜单中添加一个菜
    //TODO


    //删除
    @Transactional
    @Query("delete from OrderDishList o where o.dishId = ?1 and mdl.orderId = ?2")
    Optional<OrderDishList> deleteDishInOneMenu(Long dishId, Long orderId);



    @Modifying
    @Transactional
    @Query("update OrderDishList o set o.dishId =:#{#o.dishId}," +
            "o.dishName=:#{#o.dishName},o.dishPrice =:#{#o.dishPrice},o.actual_price =:#{#o.actual_price}," +
            "o.clientWechat =:#{#o.clientWechat}, o.isServed =:#{#o.isServed},o.add_time =:#{#o.add_time},o.serve_time =:#{#o.serve_time} " +
            "where o.id=:orderDishId and o.orderId = :orderId")
    void updateOrderDishInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("o") OrderDishList o);

    //修改是否上菜
    @Modifying
    @Transactional//开启事务
    @Query("update OrderDishList o set o.isServed = :isServed where m.id = :orderDishId and m.orderId = :orderDishId")
    void updateOrderDishStatusInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("isServed") Integer isServed);


    //修改serve_time
    @Modifying
    @Transactional//开启事务
    @Query("update OrderDishList o set o.serve_time = :serve_time where m.id = :id and m.orderId = :orderDishId")
    void updateOrderDishServeTimeInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("serve_time") Date serve_time);


    //修改actual_price
    @Modifying
    @Transactional//开启事务
    @Query("update OrderDishList o set o.actual_price = :actual_price where m.id = :id and m.orderId = :orderDishId")
    void updateOrderDishActualPriceInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("actual_price")Float actual_price);

}
