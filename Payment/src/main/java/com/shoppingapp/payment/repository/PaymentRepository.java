package com.shoppingapp.payment.repository;

import com.shoppingapp.payment.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
