package com.shoppingapp.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    private Long id;

    private String productId;
    private Long quantity;
    private Double unitPrice;

    @ManyToOne
    @JsonIgnore
    private ShoppingOrder order;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
