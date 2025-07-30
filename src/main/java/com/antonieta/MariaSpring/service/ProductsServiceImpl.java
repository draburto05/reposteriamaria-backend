package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.module.Products;
import com.antonieta.MariaSpring.repository.OrderBuyRepository;
import com.antonieta.MariaSpring.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{
    private final ProductsRepository productsRepository;

@Autowired

public ProductsServiceImpl(ProductsRepository productsRepository){
    this.productsRepository = productsRepository;
}

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("El producto con el id " + id+ " no existe")

        );
    }

    @Override
    public Products deleteProductById(Long id) {
        Products tmp = null;
        //Usamos early return para evaluar si no existe el prodcuto
        //en caso de que no existe, terminamos la ejecucion de la funcion
        //en ese momennto
        if(!productsRepository.existsById(id))return tmp;
        //si el producto existe, guardamos el producto en la variable temporal
        tmp= productsRepository.findById(id).get();
        //eliminamos el producto
        productsRepository.deleteById(id);
        //retornamos el producto eliminado
        return tmp;
    }

    @Override
    public Products addProductById(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Products UpdateProductById(Long id, Products productUpdate) {
        //Optional clase que nos permite evitar que sea nulo
        //Creando un objeto opcional de tipo Products
        Optional<Products> optionalProduct = productsRepository.findById(id);
        if(optionalProduct.isEmpty())throw
                new IllegalArgumentException("El producto con el id " + id+ " no existe");
        Products originalproduct = optionalProduct.get();
        //Evaluar el producto que hara cambio evaluando propiedades y solo donde no esten vacias se aplican cambios
        if(productUpdate.getName() !=null) originalproduct.setName(productUpdate.getName());
        if(productUpdate.getPrice() !=null) originalproduct.setPrice(productUpdate.getPrice());
        if(productUpdate.getStock() !=null) originalproduct.setStock(productUpdate.getStock());
        if(productUpdate.getTamanio() !=null) originalproduct.setTamanio(productUpdate.getTamanio());
        if(productUpdate.getSabor() !=null) originalproduct.setSabor(productUpdate.getSabor());
        return productsRepository.save(originalproduct);


    }

    @Override
    public Products addOrderProduct(Long id, OrderProductRequest orderProductRequest) {
        return null;
    }

}
