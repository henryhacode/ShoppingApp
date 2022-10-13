package com.example.AccountServices.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.micrometer.core.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accounts")
@Getter
@Setter
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<Address> shippingAddresses;

    private int preferredShipping;

    @OneToMany(cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<Payment> paymentMethods;

    private int preferredPayment;
}
