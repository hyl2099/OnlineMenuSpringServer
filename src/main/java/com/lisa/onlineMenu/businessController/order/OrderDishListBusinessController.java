package com.lisa.onlineMenu.businessController.order;

import com.lisa.onlineMenu.documents.order.OrderDishList;
import com.lisa.onlineMenu.repository.order.OrderDishListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class OrderDishListBusinessController {
    private OrderDishListRepository orderDishListRepository;

    //自动装入
    @Autowired
    public OrderDishListBusinessController(OrderDishListRepository orderDishListRepository) {
        this.orderDishListRepository = orderDishListRepository;
    }

    /****针对所有OrderDishList****/
    public Iterable<OrderDishList> readAll(){
        return this.orderDishListRepository.findAll();
    }

    public Optional<OrderDishList> searchDishById(Long id){
        return this.orderDishListRepository.findById(id);
    }

    public Optional<OrderDishList> searchDishByName(String name){
        return this.orderDishListRepository.findByName(name);
    }

    public OrderDishList saveDish(OrderDishList o){
        return this.orderDishListRepository.save(o);
    }

    public void deleteOrderById (Long id){
        this.orderDishListRepository.deleteById(id);
    }

    public Integer updateOrder(Long id, OrderDishList o){
        if (orderDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderDishListRepository.updateOrderDish(id,o);
            return 1;
        }
    }

    public Integer updateOrderDishStatus(Long id, Integer isServed){
        if (orderDishListRepository.findById(id) == null)
        {
            throw new EntityNotFoundException("the id :" + id.toString() + "Wrong, no entity.");
        }
        else {
            this.orderDishListRepository.updateOrderDishStatus(id,isServed);
            return 1;
        }
    }

    /*******针对某个order中一个菜*****/
    //查询某ID的order中所有的菜
    public Optional<OrderDishList> findAllDishInOneMenu(Long orderId){
        return this.orderDishListRepository.findAllDishList(orderId);
    }

    //查询某ID的菜单中某ID的菜
    public Optional<OrderDishList> searchDishByIdInOneOrder(Long orderId,Long orderDishId){
        return this.orderDishListRepository.searchDishByIdInOneOrder(orderId,orderDishId);
    }

    //某ID的order增加一个菜
    public int addDishInOneOrder(Long orderId,OrderDishList o){
        this.orderDishListRepository.addDishInOneOrder(orderId,o);
        return 1;
    }

    //修改某ID的order 某个菜是否上菜
    public int updateOrderDishStatusInOneOrder(Long orderId,Long orderDishId,Integer isServed){
        this.orderDishListRepository.updateOrderDishStatusInOneOrder(orderId, orderDishId,isServed);
        return 1;
    }

    //修改某ID的order 某个菜的实际价格
    public int updateOrderDishActualPriceInOneOrder(Long orderId,Long orderDishId, Float actual_price){
        this.orderDishListRepository.updateOrderDishActualPriceInOneOrder(orderId, orderDishId,actual_price);
        return 1;
    }



}
