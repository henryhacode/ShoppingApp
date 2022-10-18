package com.shoppingapp.shipping.entity;

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
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipping_generator")
    private Long id;

    String receiver;
    String street;
    String city;
    String state;
    String zipCode;
    String phone;
}
