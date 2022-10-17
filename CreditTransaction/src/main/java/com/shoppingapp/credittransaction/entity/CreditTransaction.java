package com.shoppingapp.credittransaction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CreditTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_trans_generator")
    private Long id;

    String cardNumber;
    String expireDate;
    String cvc;
    String holder;
    Double amount;
}
