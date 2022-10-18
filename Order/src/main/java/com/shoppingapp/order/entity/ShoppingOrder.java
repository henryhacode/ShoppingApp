package com.shoppingapp.order.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class ShoppingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopping_order_generator")
    private Long id;

    private Long customerId;
    private String paymentMethod;

    // Payment
    private String paymentType;
    private String paymentExpireDate;
    private String paymentCardNumber;
    private String paymentCreditHolder;
    private String paymentCvc;
    private String paymentEmail;
    private String paymentBankName;
    private String paymentBankHolder;
    private String paymentAccountNo;

    // Shipping address
    private String shippingReceiver;
//    private String shippingAddressId;
    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingZipCode;
    private String shippingPhone;

    private Double total;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL})
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
        for (Product product : products) {
            product.setOrder(this);
        }
    }
}
