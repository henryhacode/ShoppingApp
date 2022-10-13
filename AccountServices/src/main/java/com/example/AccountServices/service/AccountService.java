package com.example.AccountServices.service;

import com.example.AccountServices.dto.AccountDto;
import com.example.AccountServices.entity.Address;
import com.example.AccountServices.entity.Payment;

public interface AccountService {
    AccountDto findByEmail(String email);
    AccountDto addShippingAddress(String email, Address address);

    AccountDto removeShippingAddress(String email, int id);

    AccountDto setPreferredShippingAddress(String email, int id);

    AccountDto addPaymentMethod(String email, Payment payment);

    AccountDto removePaymentMethod(String email, int id);

    AccountDto setPreferredPaymentMethod(String email, int id);

}
