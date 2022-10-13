package com.example.AccountServices.service.impl;

import com.example.AccountServices.dto.AccountDto;
import com.example.AccountServices.entity.Account;
import com.example.AccountServices.entity.Address;
import com.example.AccountServices.entity.Payment;
import com.example.AccountServices.exception.NotFoundException;
import com.example.AccountServices.repository.AccountRepository;
import com.example.AccountServices.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper mapper;

    @Override
    public AccountDto findByEmail(String email){
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        return mapper.map(account, AccountDto.class);
    }

    @Override
    //@Transactional
    public AccountDto addShippingAddress(String email, Address newAddress) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        account.getShippingAddresses().add(newAddress);

        accountRepository.save(account);

        //set preferred address
        if(account.getShippingAddresses().size() == 1){
            account.setPreferredShipping(account.getShippingAddresses().get(0).getId());
            accountRepository.save(account);
        }

        return mapper.map(account, AccountDto.class);
    }


    @Override
    //@Transactional
    public AccountDto removeShippingAddress(String email, int id) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        List<Address> addresses = account.getShippingAddresses();
        for(int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).getId() == id) {
                addresses.remove(i);
            }
        }

        accountRepository.save(account);

        //set preferred address
        if(account.getShippingAddresses().size() == 1){
            account.setPreferredShipping(account.getShippingAddresses().get(0).getId());
            accountRepository.save(account);
        }

        return mapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto setPreferredShippingAddress(String email, int id) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        List<Address> addresses = account.getShippingAddresses();
        for(int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).getId() == id) {
                account.setPreferredShipping(addresses.get(i).getId());
                accountRepository.save(account);
                break;
            }
        }

        return mapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto addPaymentMethod(String email, Payment newPayment) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        account.getPaymentMethods().add(newPayment);

        accountRepository.save(account);

        //set preferred payment
        if(account.getPaymentMethods().size() == 1){
            account.setPreferredPayment(account.getPaymentMethods().get(0).getId());
            accountRepository.save(account);
        }

        return mapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto removePaymentMethod(String email, int id) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        List<Payment> payments = account.getPaymentMethods();
        for(int i = 0; i < payments.size(); i++) {
            if (payments.get(i).getId() == id) {
                payments.remove(i);
            }
        }

        accountRepository.save(account);

        //set preferred payment
        if(account.getPaymentMethods().size() == 1){
            account.setPreferredPayment(account.getPaymentMethods().get(0).getId());
            accountRepository.save(account);
        }

        return mapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto setPreferredPaymentMethod(String email, int id) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Data Not Found " + email));
        List<Payment> payments = account.getPaymentMethods();
        for(int i = 0; i < payments.size(); i++) {
            if (payments.get(i).getId() == id) {
                account.setPreferredPayment(payments.get(i).getId());
                accountRepository.save(account);
                break;
            }
        }

        return mapper.map(account, AccountDto.class);
    }
}
