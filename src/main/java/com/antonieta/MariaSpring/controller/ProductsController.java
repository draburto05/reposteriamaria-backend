package com.antonieta.MariaSpring.controller;

import com.antonieta.MariaSpring.module.Products;
import com.antonieta.MariaSpring.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/products")//http://localhost:8080/api/products
//lombok nos ayuda a evitar codigo del constructor
@AllArgsConstructor
public class ProductsController {


        //inyeccion de dependencias
        private ProductsService productsService;

        @GetMapping //http://localhost:8080/api/products
        public List<Products> getAllProducts(){
            return this.productsService.getAllProducts();
        }

        //peticion get para obtener producto por ID
        @GetMapping(path="{productId}") //http://localhost:8080/api/products/2

        public Products getProductById(@PathVariable("productId")Long id){
            return this.productsService.getProductById(id);
        }

        //Peticion delete
    @DeleteMapping(path = "{productId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 pero con peticion tipo delete
    public Products deleteProductById(@PathVariable("productId")Long id){
        return this.productsService.deleteProductById(id);
    }



        //Peticion post
        @PostMapping //http://localhost:8080/api/products
        public Products addProduct(@RequestBody Products products){
            return this.productsService.addProductById(products);
        }

        //peticion PUT
        @PutMapping(path ="{productId}") //http://localhost:8080/api/products/id http://localhost:8080/api/products/id http://localhost:8080/api/products/2
        public Products updateProductById(@PathVariable("productId") Long id,@RequestBody Products productUpdated){
            return this.productsService.UpdateProductById(id, productUpdated);
        }
}
