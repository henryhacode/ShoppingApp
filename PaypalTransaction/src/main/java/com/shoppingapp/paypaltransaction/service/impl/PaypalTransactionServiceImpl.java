package com.shoppingapp.paypaltransaction.service.impl;

import com.shoppingapp.paypaltransaction.entity.PaypalTransaction;
import com.shoppingapp.paypaltransaction.repository.PaypalRepository;
import com.shoppingapp.paypaltransaction.service.PaypalTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaypalTransactionServiceImpl implements PaypalTransactionService {
    private final PaypalRepository paypalRepository;

    @Override
    public List<PaypalTransaction> findAll() {
        return (List<PaypalTransaction>)paypalRepository.findAll();
    }

    @Override
    public PaypalTransaction findById(Long id) {
        return paypalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(PaypalTransaction paypalTransaction) {
        System.out.println("==== Bank Transaction: Processing");
        System.out.println(paypalTransaction);
        paypalRepository.save(paypalTransaction);
        System.out.println("==== Bank Transaction: DONE");
    }

    @Override
    public PaypalTransaction delete(Long id) {
        PaypalTransaction paypalTransaction = paypalRepository.findById(id).orElse(null);
        paypalRepository.deleteById(id);
        return paypalTransaction;
    }
}
