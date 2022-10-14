package com.shoppingapp.order.repository;

import com.shoppingapp.order.entity.ShoppingOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<ShoppingOrder, Long> {
    List<ShoppingOrder> findOrdersByCustomerId(Long customerId);
}
