package com.shoppingapp.credittransaction.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class CreditTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_trans_generator")
    private Long id;

    String cardNumber;
    String expireDate;
    String cvc;
    String creditHolder;
    Double total;
}
