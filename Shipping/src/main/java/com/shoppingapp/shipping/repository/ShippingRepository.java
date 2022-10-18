package com.shoppingapp.shipping.repository;

import com.shoppingapp.shipping.entity.Shipping;
import org.springframework.data.repository.CrudRepository;

public interface ShippingRepository extends CrudRepository<Shipping, Long> {
}
