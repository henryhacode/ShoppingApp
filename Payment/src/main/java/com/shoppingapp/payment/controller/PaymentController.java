package com.shoppingapp.payment.controller;

import com.shoppingapp.payment.entity.Payment;
import com.shoppingapp.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return paymentService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Payment payment) {
        System.out.println("Post payment controller");
        System.out.println(payment);
        paymentService.process(payment);
    }

    @DeleteMapping("/{id}")
    public Payment delete(@PathVariable Long id) {
        return paymentService.delete(id);
    }
}
