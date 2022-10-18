package com.shoppingapp.payment.service.Impl;

import com.shoppingapp.payment.entity.Payment;
import com.shoppingapp.payment.repository.PaymentRepository;
import com.shoppingapp.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final Environment environment;

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
        System.out.println("Process payment");
        System.out.println(payment);
        String type = payment.getType();
        if (type == null) {
            type = "CREDIT";
        }
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

        WebClient webClient = WebClient.create(transactionUrl);
        webClient.post()
                .uri(subUrl)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(void.class);

        // store value
        paymentRepository.save(payment);
    }

    @Override
    public Payment delete(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        paymentRepository.deleteById(id);
        return payment;
    }
}
