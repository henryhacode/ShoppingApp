package com.example.ProductServices.service.impl;

import com.example.ProductServices.dto.ProductDto;
import com.example.ProductServices.entity.Product;
import com.example.ProductServices.exception.MyException;
import com.example.ProductServices.repository.ProductRepository;
import com.example.ProductServices.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public ProductDto findById(int id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new MyException("Data Not Found " + id));
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto addProduct(Product product) {
        productRepository.save(product);
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new MyException("Data Not Found " + id));
        productRepository.deleteById(id);
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(Product product) {
        Product temp = productRepository.save(product);
        return mapper.map(temp, ProductDto.class);
    }

    @Override
    public ProductDto orderProduct(int id, int number) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new MyException("Data Not Found " + id));

        int newUnits = product.getUnits() - number;
        if(newUnits < 0){
            throw new MyException("units negative");
        }

        product.setUnits(newUnits);
        productRepository.save(product);
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto addStock(int id, int number) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new MyException("Data Not Found " + id));

        int newUnits = product.getUnits() + number;
        product.setUnits(newUnits);
        productRepository.save(product);
        return mapper.map(product, ProductDto.class);
    }
}
