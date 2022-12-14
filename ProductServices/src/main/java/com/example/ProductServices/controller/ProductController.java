package com.example.ProductServices.controller;

import com.example.ProductServices.dto.ProductDto;
import com.example.ProductServices.entity.Product;
import com.example.ProductServices.service.ProductService;
import com.example.ProductServices.util.security.TokenUserDetail;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public void products(){
        System.out.println("GET /products/");
    }
    //Get Product info: GET
    @GetMapping("{id}")
    public ProductDto findById(@PathVariable int id){
        System.out.println("Product:  findById");
        return productService.findById(id);
    }

    //Add product: POST
    @PostMapping("")
    public ProductDto addProduct(@RequestBody Product product){
        System.out.println("Product:  addProduct");
//        if(!TokenUserDetail.hasRoleAdmin())
//            return null;
        return productService.addProduct(product);
    }

    //Remove product: DELETE
    @DeleteMapping("{id}")
    public ProductDto deleteProduct(@PathVariable int id){
        System.out.println("Product:  deleteProduct");
//        if(!TokenUserDetail.hasRoleAdmin())
//            return null;
        return productService.deleteProduct(id);
    }

    //Update product: PUT
    @PutMapping("")
    public ProductDto updateProduct(@RequestBody Product product){
        System.out.println("Product:  updateProduct");
//        if(!TokenUserDetail.hasRoleAdmin())
//            return null;
        return productService.updateProduct(product);
    }

    //Order product: PATCH
    @PostMapping("{id}/order/{num}")
    public ProductDto orderProduct(@PathVariable int id, @PathVariable int num){
        System.out.println("Product:  orderProduct");
//        if(!TokenUserDetail.hasRoleUser())
//            return null;
        return productService.orderProduct(id, num);
    }

    //Add stock: POST
    @PostMapping("{id}/add/{num}")
    public ProductDto addStock(@PathVariable int id, @PathVariable int num){
        System.out.println("Product:  addStock");
//        if(!TokenUserDetail.hasRoleAdmin())
//            return null;
        return productService.addStock(id, num);
    }
}
