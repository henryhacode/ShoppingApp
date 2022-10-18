package com.shoppingapp.shipping.service.impl;

import com.shoppingapp.shipping.entity.Shipping;
import com.shoppingapp.shipping.repository.ShippingRepository;
import com.shoppingapp.shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {
    private final ShippingRepository shippingRepository;

    @Override
    public List<Shipping> findAll() {
        return (List<Shipping>) shippingRepository.findAll();
    }

    @Override
    public Shipping findById(Long id) {
        return shippingRepository.findById(id).orElse(null);
    }

    @Override
    public void process(Shipping shipping) {
        // save (process)
        shippingRepository.save(shipping);

        // call notification
    }

    @Override
    public Shipping delete(Long id) {
        Shipping shipping = shippingRepository.findById(id).orElse(null);
        shippingRepository.deleteById(id);
        return shipping;
    }
}
