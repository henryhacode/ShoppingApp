package com.shoppingapp.credittransaction.service.impl;

import com.shoppingapp.credittransaction.entity.CreditTransaction;
import com.shoppingapp.credittransaction.repository.CreditRepository;
import com.shoppingapp.credittransaction.service.CreditTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditTransactionServiceImpl implements CreditTransactionService {
    private final CreditRepository creditRepository;

    @Override
    public List<CreditTransaction> findAll() {
        return (List<CreditTransaction>)creditRepository.findAll();
    }

    @Override
    public CreditTransaction findById(Long id) {
        return creditRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CreditTransaction creditTransaction) {
        creditRepository.save(creditTransaction);
    }

    @Override
    public CreditTransaction delete(Long id) {
        CreditTransaction creditTransaction = creditRepository.findById(id).orElse(null);
        creditRepository.deleteById(id);
        return creditTransaction;
    }
}
