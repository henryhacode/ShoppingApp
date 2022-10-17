package com.shoppingapp.paypaltransaction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class PaypalTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paypal_trans_generator")
    private Long id;

    String email;
    Double amount;
}
