package com.lisa.onlineMenu.repository.order;

import com.lisa.onlineMenu.documents.order.OrderDishList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderDishListRepository extends CrudRepository<OrderDishList, Long> {
    /*************整体修改***/
    @Modifying
    @Transactional
    @Query(value = "update OrderDishList o set o.orderId = :#{#o.orderId},o.dishId =:#{#o.dishId}," +
            "o.dishName=:#{#o.dishName},o.dishPrice =:#{#o.dishPrice},o.actual_price =:#{#o.actual_price}," +
            "o.clientWechat =:#{#o.clientWechat}, o.isServed =:#{#o.isServed},o.add_time =:#{#o.add_time},o.serve_time =:#{#o.serve_time} where o.id=:id", nativeQuery = true)
    void updateOrderDish(@Param("id")Long id, @Param("o") OrderDishList o);

    @Transactional
    @Query(value = "select o from OrderDishList o where o.name = ?1", nativeQuery = true)
    Optional<OrderDishList> findByName(String name);

    //修改是否上菜
    @Modifying
    @Transactional//开启事务
    @Query(value = "update OrderDishList o set o.isServed = :isServed where m.id = :id", nativeQuery = true)
    void updateOrderDishStatus(@Param("id")Long id, @Param("isServed") Integer isServed);

    //修改serve_time
    @Modifying
    @Transactional//开启事务
    @Query(value = "update OrderDishList o set o.serve_time = :serve_time where m.id = :id", nativeQuery = true)
    void updateOrderDishServeTime(@Param("id")Long id, @Param("serve_time") Date serve_time);


    //修改actual_price
    @Modifying
    @Transactional//开启事务
    @Query(value = "update OrderDishList o set o.actual_price = :actual_price where m.id = :id", nativeQuery = true)
    void updateOrderDishActualPrice(@Param("id")Long id, @Param("actual_price")Float actual_price);




    /***********************针对某个order中一个菜**************/
    //查找某ID的order中的所有菜
    @Transactional
    @Query(value = "select o from OrderDishList o where o.orderId = ?1", nativeQuery = true)
    Optional<OrderDishList> findAllDishList(Long orderId);

    //查找某id order中某id的菜
    @Transactional
    @Query(value = "select o from OrderDishList o where o.orderId = ?1 and o.id = ?2", nativeQuery = true)
    Optional<OrderDishList> searchDishByIdInOneOrder(Long orderId, Long orderDishId);

    //某个order中添加一个菜
    @Modifying
    @Transactional
    @Query(value = "insert into MenuDishList mdl (orderId,dishId,dishName,dishPrice,actual_price,clientWechat,isServed,add_time,serve_time) " +
            "VALUES (:orderId, :#{#o.dishId},:#{#o.dishName},:#{#o.dishPrice},:#{#o.actual_price},:#{#o.clientWechat}," +
            ":#{#o.isServed},:#{#o.add_time},:#{#o.serve_time})", nativeQuery = true)
    void addDishInOneOrder(@Param("orderId")Long menuId,  @Param("o") OrderDishList o);



    //删除
    @Transactional
    @Query(value = "delete from OrderDishList o where o.dishId = ?1 and mdl.orderId = ?2", nativeQuery = true)
    Optional<OrderDishList> deleteDishInOneMenu(Long dishId, Long orderId);



    @Modifying
    @Transactional
    @Query(value = "update OrderDishList o set o.dishId =:#{#o.dishId}," +
            "o.dishName=:#{#o.dishName},o.dishPrice =:#{#o.dishPrice},o.actual_price =:#{#o.actual_price}," +
            "o.clientWechat =:#{#o.clientWechat}, o.isServed =:#{#o.isServed},o.add_time =:#{#o.add_time},o.serve_time =:#{#o.serve_time} " +
            "where o.id=:orderDishId and o.orderId = :orderId", nativeQuery = true)
    void updateOrderDishInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("o") OrderDishList o);

    //修改是否上菜
    @Modifying
    @Transactional//开启事务
    @Query(value = "update OrderDishList o set o.isServed = :isServed where m.id = :orderDishId and m.orderId = :orderId", nativeQuery = true)
    void updateOrderDishStatusInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("isServed") Integer isServed);


    //修改serve_time
//    @Modifying
//    @Transactional//开启事务
//    @Query("update OrderDishList o set o.serve_time = :serve_time where m.id = :orderDishId and m.orderId = :orderId")
//    void updateOrderDishServeTimeInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("serve_time") Date serve_time);


//    //修改actual_price
//    @Modifying
//    @Transactional//开启事务
//    @Query("update OrderDishList o set o.actual_price = :actual_price where m.id = :orderDishId and m.orderId = :orderId")
//    void updateOrderDishActualPriceInOneOrder(@Param("orderId")Long orderId,@Param("orderDishId")Long orderDishId, @Param("actual_price")Float actual_price);

}
