package com.shoppingapp.order.service.impl;

import com.shoppingapp.order.entity.ShoppingOrder;
import com.shoppingapp.order.repository.OrderRepository;
import com.shoppingapp.order.service.OrderService;
import lombok.*;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Data
@NoArgsConstructor
class Payment {
    String type;

    // credit
    String cardNumber;
    String expireDate;
    String cvc;
    String creditHolder;

    // paypal
    String email;

    // bank
    String bankName;
    String accountNo;
    String bankHolder;

    Double total;
}

@Data
@NoArgsConstructor
class Shipping {
    String receiver;
    String street;
    String city;
    String state;
    String zipCode;
    String phone;
}

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final Environment environment;
    private final RestTemplate restTemplate;


    @Override
    public List<ShoppingOrder> findAll() {
        return (List<ShoppingOrder>) orderRepository.findAll();
    }

    @Override
    public List<ShoppingOrder> findByCustomerId(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public ShoppingOrder findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ShoppingOrder shoppingOrder) {
        System.out.println(shoppingOrder);

        // Process payment
        try {
            String paymentUrl = environment.getProperty("PAYMENT_SERVICE_URL") ;
            System.out.println("payment url: " + paymentUrl);
            paymentUrl += "/payments";
            System.out.println("Calling payment service " + paymentUrl);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            Payment payment = new Payment();
            payment.type = shoppingOrder.getPaymentType();
            if (payment.type == null) {
                payment.type = "CREDIT";
            }
            payment.type = payment.type.toUpperCase();
            payment.total = shoppingOrder.getTotal();
            switch (payment.type) {
                case "CREDIT":
                    payment.cardNumber = shoppingOrder.getPaymentCardNumber();
                    payment.expireDate = shoppingOrder.getPaymentExpireDate();
                    payment.cvc = shoppingOrder.getPaymentCvc();
                    payment.creditHolder  = shoppingOrder.getPaymentCreditHolder();
                    break;
                case "PAYPAL":
                    payment.email = shoppingOrder.getPaymentEmail();
                    break;
                default:
                    payment.bankName = shoppingOrder.getPaymentBankName();
                    payment.bankHolder = shoppingOrder.getPaymentBankHolder();
                    payment.accountNo = shoppingOrder.getPaymentAccountNo();
                    break;
            }
            HttpEntity<Payment> entity = new HttpEntity<>(payment, headers);
            restTemplate.postForEntity(paymentUrl, entity, Void.class);
        } catch (Exception ex) {
            System.out.println("==============  Error calling payment " + ex);
        }

        try {
            String shippingUrl = environment.getProperty("SHIPPING_SERVICE_URL");
            System.out.println("shipping url: " + shippingUrl);
            shippingUrl += "/shippings";
            System.out.println("Calling shipping service " + shippingUrl);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            Shipping shipping = new Shipping();
            shipping.receiver = shoppingOrder.getShippingReceiver();
            shipping.street = shoppingOrder.getShippingStreet();
            shipping.city = shoppingOrder.getShippingCity();
            shipping.state = shoppingOrder.getShippingState();
            shipping.zipCode = shoppingOrder.getShippingZipCode();
            shipping.phone = shoppingOrder.getShippingPhone();

            HttpEntity<Shipping> entity = new HttpEntity<>(shipping, headers);
            restTemplate.postForEntity(shippingUrl, entity, Void.class);
        } catch (Exception ex) {
            System.out.println("==============  Error calling shipping " + ex);
        }
            orderRepository.save(shoppingOrder);
    }

    @Override
    public ShoppingOrder delete(Long id) {
        ShoppingOrder shoppingOrder = orderRepository.findById(id).orElse(null);
        orderRepository.deleteById(id);
        return shoppingOrder;
    }
}
