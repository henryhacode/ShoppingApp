package com.shoppingapp.payment.service;

import com.shoppingapp.payment.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();
    Payment findById(Long id);
    void process(Payment payment);
    Payment delete(Long id);
}
