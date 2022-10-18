package com.shoppingapp.shipping.service;

import com.shoppingapp.shipping.entity.Shipping;

import java.util.List;

public interface ShippingService {
    List<Shipping> findAll();
    Shipping findById(Long id);
    void process(Shipping shipping);
    Shipping delete(Long id);
}
