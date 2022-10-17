package com.shoppingapp.banktransaction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_trans_generator")
    private Long id;

    String bankName;
    String accountNo;
    String holder;
}
