package com.example.ProductServices.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="products")
@Getter
@Setter
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    private String vendor;
    private String category;
    private String description;
    private int units;
}
