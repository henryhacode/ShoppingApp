package com.shoppingapp.shipping.controller;

import com.shoppingapp.shipping.entity.Shipping;
import com.shoppingapp.shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shippings")
@RequiredArgsConstructor
public class ShippingController {
    private final ShippingService shippingService;

    @GetMapping
    public List<Shipping> getAll() {
        return shippingService.findAll();
    }

    @GetMapping("/{id}")
    public Shipping getById(@PathVariable Long id) {
        return shippingService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Shipping shipping) {
        System.out.println(shipping);
        shippingService.process(shipping);
    }

    @DeleteMapping("/{id}")
    public Shipping delete(@PathVariable Long id) {
        return shippingService.delete(id);
    }
}
