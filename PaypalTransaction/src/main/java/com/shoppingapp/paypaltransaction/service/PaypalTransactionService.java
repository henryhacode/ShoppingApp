package com.shoppingapp.paypaltransaction.service;

import com.shoppingapp.paypaltransaction.entity.PaypalTransaction;

import java.util.List;

public interface PaypalTransactionService {
    List<PaypalTransaction> findAll();
    PaypalTransaction findById(Long id);
    void save(PaypalTransaction creditTransaction);
    PaypalTransaction delete(Long id);
}
