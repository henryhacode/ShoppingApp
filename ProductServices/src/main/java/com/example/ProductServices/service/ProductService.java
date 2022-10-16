package com.example.ProductServices.service;

import com.example.ProductServices.dto.ProductDto;
import com.example.ProductServices.entity.Product;

public interface ProductService {
    ProductDto findById(int id);
    ProductDto addProduct(Product product);
    ProductDto deleteProduct(int id);
    ProductDto updateProduct(Product product);
    ProductDto orderProduct(int id, int number);
    ProductDto addStock(int id, int number);
}
