package com.shoppingapp.paypaltransaction.controller;

import com.shoppingapp.paypaltransaction.entity.PaypalTransaction;
import com.shoppingapp.paypaltransaction.service.PaypalTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paypal")
@CrossOrigin()
@RequiredArgsConstructor
public class PaypalTransactionController {
    private final PaypalTransactionService transactionService;

    @GetMapping
    public List<PaypalTransaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public PaypalTransaction getById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PaypalTransaction paypalTransaction) {
        System.out.println(paypalTransaction);
        transactionService.save(paypalTransaction);
    }

    @DeleteMapping("/{id}")
    public PaypalTransaction delete(@PathVariable Long id) {
        return transactionService.delete(id);
    }
}
