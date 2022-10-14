package com.shoppingapp.order.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class ShoppingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopping_order_generator")
    private Long id;

    private Long customerId;
    private String paymentMethod;

    // Shipping address
    private String shippingAddressId;
    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingZipCode;

    private Long total;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL})
    private List<Product> products;

    public void setProducts(List<Product> products) {
        this.products = products;
        for (Product product : products) {
            product.setOrder(this);
        }
    }

    @Override
    public String toString() {
        return "ShoppingOrder{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", shippingAddressId='" + shippingAddressId + '\'' +
                ", shippingStreet='" + shippingStreet + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingState='" + shippingState + '\'' +
                ", shippingZipCode='" + shippingZipCode + '\'' +
                ", total=" + total +
                ", products=" + products +
                '}';
    }
}
