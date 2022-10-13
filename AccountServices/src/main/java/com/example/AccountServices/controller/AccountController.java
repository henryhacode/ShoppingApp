package com.example.AccountServices.controller;

import com.example.AccountServices.dto.AccountDto;
import com.example.AccountServices.entity.Address;
import com.example.AccountServices.entity.Payment;
import com.example.AccountServices.service.AccountService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public void accounts(){
        System.out.println("GET /accounts/");
    }
    //Get Account info: GET
    @GetMapping("{email}")
    public AccountDto findByEmail(@PathVariable String email){
        System.out.println("findByEmail");
        System.out.println("GET /accounts/"+email);
        return accountService.findByEmail(email);
    }

    //Add shipping address: PUT
    @PutMapping("{email}/addresses")
    public AccountDto addShippingAddress(@PathVariable String email, @RequestBody Address address){
        System.out.println("addShippingAddress");
        System.out.println("PUT /accounts/"+email+"/addresses");
        System.out.println("requestbody: "+address);
        return accountService.addShippingAddress(email, address);
    }

    //Remove shipping address: DELETE
    @DeleteMapping("{email}/addresses/{id}")
    public AccountDto removeShippingAddress(@PathVariable String email, @PathVariable int id){
        System.out.println("removeShippingAddress");
        System.out.println("DELETE /accounts/"+email+"/addresses/"+id);
        return accountService.removeShippingAddress(email, id);
    }

    //Set preferred shipping address: PATCH
    @PatchMapping("{email}/addresses/{id}")
    public AccountDto setPreferredShippingAddress(@PathVariable String email, int id){
        System.out.println("setPreferredShippingAddress");
        System.out.println("PATCH /accounts/"+email+"/addresses/"+id);
        return accountService.setPreferredShippingAddress(email, id);
    }

    //Add payment method: PUT
    @PutMapping("{email}/payments")
    public AccountDto addPaymentMethod(@PathVariable String email, @RequestBody Payment payment){
        return accountService.addPaymentMethod(email, payment);
    }

    //Remove payment: DELETE
    @DeleteMapping("{email}/payments/{id}")
    public AccountDto removePaymentMethod(@PathVariable String email, @PathVariable int id){
        return accountService.removePaymentMethod(email, id);
    }

    //Set preferred payment method: PATCH
    @PatchMapping("{email}/payments/{id}")
    public AccountDto setPreferredPaymentMethod(@PathVariable String email, int id) {
        return accountService.setPreferredPaymentMethod(email, id);
    }
}
