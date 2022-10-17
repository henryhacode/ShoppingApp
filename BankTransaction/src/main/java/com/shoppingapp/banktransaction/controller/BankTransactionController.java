package com.shoppingapp.banktransaction.controller;

import com.shoppingapp.banktransaction.entity.BankTransaction;
import com.shoppingapp.banktransaction.service.BankTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankTrans")
@CrossOrigin()
@RequiredArgsConstructor
public class BankTransactionController {
    private final BankTransactionService transactionService;

    @GetMapping
    public List<BankTransaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public BankTransaction getById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody BankTransaction creditTransaction) {
        System.out.println(creditTransaction);
        transactionService.save(creditTransaction);
    }

    @DeleteMapping("/{id}")
    public BankTransaction delete(@PathVariable Long id) {
        return transactionService.delete(id);
    }
}
