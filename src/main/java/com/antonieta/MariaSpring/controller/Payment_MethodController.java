package com.antonieta.MariaSpring.controller;


import com.antonieta.MariaSpring.module.Payment_method;
import com.antonieta.MariaSpring.module.Products;
import com.antonieta.MariaSpring.service.Payment_MethodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/api/payment_methods")
@RestController
@AllArgsConstructor
public class Payment_MethodController {
    private Payment_MethodService payment_methodServive;

    @GetMapping
    public List<Payment_method> getAllPayment_Methods(){
        return this.payment_methodServive.getAllPayment_method();
    }

    @GetMapping(path = "{Payment_methodId}")
    public Payment_method getPayment_methodById(@PathVariable("Payment_methodId")Long id){
        return this.payment_methodServive.getPayment_methodById(id);
    }

    @DeleteMapping(path = "{Payment_methodId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 pero con peticion tipo delete
    public Payment_method deletePayment_methodById(@PathVariable("Payment_methodId")Long id){
        return this.payment_methodServive.deletePayment_methodById(id);
    }


    @PostMapping
    public Payment_method addPayment_Methods(@RequestBody Payment_method payment_Methods) {
        return this.payment_methodServive.addPayment_methodById(payment_Methods);
    }


        @PutMapping(path = "{Payment_methodId}")
        public Payment_method UpdatePayment_methodById(@PathVariable("Payment_methodId")Long id, @RequestBody Payment_method payment_methodUpdated){
            return this.payment_methodServive.UpdatePayment_methodById(id, payment_methodUpdated);
        }
    }
