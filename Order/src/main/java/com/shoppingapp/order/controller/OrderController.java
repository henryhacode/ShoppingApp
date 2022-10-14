package com.shoppingapp.order.controller;

import com.shoppingapp.order.entity.ShoppingOrder;
import com.shoppingapp.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin()
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<ShoppingOrder> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public List<ShoppingOrder> getByCustomerId(@PathVariable Long customerId) {
        return orderService.findByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    public ShoppingOrder getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ShoppingOrder shoppingOrder) {
        System.out.println(shoppingOrder);
        orderService.save(shoppingOrder);
    }

    @DeleteMapping("/{id}")
    public ShoppingOrder deleteById(@PathVariable Long id) {
        return orderService.delete(id);
    }
}
