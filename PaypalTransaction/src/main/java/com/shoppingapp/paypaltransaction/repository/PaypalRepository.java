package com.shoppingapp.paypaltransaction.repository;

import com.shoppingapp.paypaltransaction.entity.PaypalTransaction;
import org.springframework.data.repository.CrudRepository;

public interface PaypalRepository extends CrudRepository<PaypalTransaction, Long> {
}
