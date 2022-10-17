package com.shoppingapp.credittransaction.repository;

import com.shoppingapp.credittransaction.entity.CreditTransaction;
import org.springframework.data.repository.CrudRepository;

public interface CreditRepository extends CrudRepository<CreditTransaction, Long> {
}
