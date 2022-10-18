package com.shoppingapp.payment.service.Impl;

import com.shoppingapp.payment.entity.Payment;
import com.shoppingapp.payment.repository.PaymentRepository;
import com.shoppingapp.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final Environment environment;
    private final RestTemplate restTemplate;

    @Override
    public List<Payment> findAll() {
        return (List<Payment>) paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public void process(Payment payment) {
        System.out.println("====== Payment: processing");
        System.out.println(payment);
        String type = payment.getType();
        if (type == null) {
            type = "CREDIT";
        }
        // TODO: get subUrl from env
        String subUrl = "";
        switch (type) {
            case "CREDIT":
                subUrl = "/creditTrans";
                break;
            case "PAYPAL":
                subUrl = "/paypalTrans";
                break;
            default:
                subUrl = "/bankTrans";
                break;
        }
        // call to specific transaction service
        String transactionUrl = environment.getProperty(type + "_TRANSACTION_SERVICE_URL");
        System.out.println("transaction type: " + type + ", url: " + transactionUrl);

        if (transactionUrl == null) {
            System.out.println("TransactionUrl is null");
            return;
        }

        try {
            transactionUrl += subUrl;
            System.out.println("Calling payment service " + transactionUrl);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<Payment> entity = new HttpEntity<>(payment, headers);
            restTemplate.postForEntity(transactionUrl, entity, Void.class);
            System.out.println("Process at specific transaction: DONE--------");
        } catch (Exception ex) {
            System.out.println("==============  Error calling transaction " + ex);
        }

        // store value
        paymentRepository.save(payment);

        System.out.println("====== Payment: all DONE");
    }

    @Override
    public Payment delete(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        paymentRepository.deleteById(id);
        return payment;
    }
}
