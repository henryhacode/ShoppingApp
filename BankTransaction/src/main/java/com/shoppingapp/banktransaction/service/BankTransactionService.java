package com.shoppingapp.banktransaction.service;

import com.shoppingapp.banktransaction.entity.BankTransaction;

import java.util.List;

public interface BankTransactionService {
    List<BankTransaction> findAll();
    BankTransaction findById(Long id);
    void save(BankTransaction bankTransaction);
    BankTransaction delete(Long id);
}
