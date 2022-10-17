package com.shoppingapp.banktransaction.repository;

import com.shoppingapp.banktransaction.entity.BankTransaction;
import org.springframework.data.repository.CrudRepository;

public interface BankTransactionRepository extends CrudRepository<BankTransaction, Long> {
}
