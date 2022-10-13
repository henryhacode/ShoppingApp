package com.example.AccountServices.dto;

import com.example.AccountServices.entity.Address;
import com.example.AccountServices.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> shippingAddresses;
    private int preferredShipping;
    private List<Payment> paymentMethods;
    private int preferredPayment;
}
