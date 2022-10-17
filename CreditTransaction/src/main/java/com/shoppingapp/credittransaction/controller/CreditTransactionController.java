package com.shoppingapp.credittransaction.controller;

import com.shoppingapp.credittransaction.entity.CreditTransaction;
import com.shoppingapp.credittransaction.repository.CreditRepository;
import com.shoppingapp.credittransaction.service.CreditTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditTrans")
@CrossOrigin()
@RequiredArgsConstructor
public class CreditTransactionController {
    private final CreditTransactionService transactionService;

    @GetMapping
    public List<CreditTransaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public CreditTransaction getById(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CreditTransaction creditTransaction) {
        System.out.println(creditTransaction);
        transactionService.save(creditTransaction);
    }

    @DeleteMapping("/{id}")
    public CreditTransaction delete(@PathVariable Long id) {
        return transactionService.delete(id);
    }
}
