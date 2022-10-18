package com.shoppingapp.banktransaction.service.impl;

import com.shoppingapp.banktransaction.entity.BankTransaction;
import com.shoppingapp.banktransaction.repository.BankTransactionRepository;
import com.shoppingapp.banktransaction.service.BankTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankTransactionServiceImpl implements BankTransactionService {
    private final BankTransactionRepository transactionRepository;

    @Override
    public List<BankTransaction> findAll() {
        return (List<BankTransaction>) transactionRepository.findAll();
    }

    @Override
    public BankTransaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BankTransaction bankTransaction) {
        System.out.println("==== Bank Transaction: Processing");
        System.out.println(bankTransaction);
        transactionRepository.save(bankTransaction);
        System.out.println("==== Bank Transaction: DONE");
    }

    @Override
    public BankTransaction delete(Long id) {
        BankTransaction bankTransaction = transactionRepository.findById(id).orElse(null);
        transactionRepository.deleteById(id);
        return bankTransaction;
    }
}
