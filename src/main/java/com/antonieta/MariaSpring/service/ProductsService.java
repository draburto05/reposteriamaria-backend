package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.module.Products;

import java.util.List;

public interface ProductsService {
    List<Products> getAllProducts();

    Products getProductById(Long id);
    Products deleteProductById(Long id);
    Products addProductById(Products product);
    Products UpdateProductById(Long id,Products productUpdate);

    Products addOrderProduct(Long id, OrderProductRequest orderProductRequest);
}
