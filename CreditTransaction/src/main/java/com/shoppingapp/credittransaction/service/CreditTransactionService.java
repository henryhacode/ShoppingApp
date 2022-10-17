package com.shoppingapp.credittransaction.service;

import com.shoppingapp.credittransaction.entity.CreditTransaction;

import java.util.List;

public interface CreditTransactionService {
    List<CreditTransaction> findAll();
    CreditTransaction findById(Long id);
    void save(CreditTransaction creditTransaction);
    CreditTransaction delete(Long id);
}
