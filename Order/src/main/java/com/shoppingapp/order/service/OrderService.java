package com.shoppingapp.order.service;

import com.shoppingapp.order.entity.ShoppingOrder;

import java.util.List;

public interface OrderService {
    List<ShoppingOrder> findAll();
    List<ShoppingOrder> findByCustomerId(Long customerId);
    ShoppingOrder findById(Long id);
    void save(ShoppingOrder shoppingOrder);
    ShoppingOrder delete(Long id);
}
