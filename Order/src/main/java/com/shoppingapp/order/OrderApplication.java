package com.shoppingapp.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        System.out.println("=============================================== DB_URL");
        System.out.println(System.getenv("DB_URL"));
        System.out.println("===============================================END----------");
        SpringApplication.run(OrderApplication.class, args);
    }

}
