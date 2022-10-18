package com.shoppingapp.payment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_generator")
    private Long id;

    String type;

    // credit
    String cardNumber;
    String expireDate;
    String cvc;
    String creditHolder;

    // paypal
    String email;

    // bank
    String bankName;
    String accountNo;
    String bankHolder;

    Double amount;
}
