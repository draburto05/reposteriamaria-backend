package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.module.Payment_method;

import java.util.List;

public interface Payment_MethodService {

    List<Payment_method> getAllPayment_method();

    Payment_method getPayment_methodById(Long id);
    Payment_method deletePayment_methodById(Long id);
    Payment_method addPayment_methodById(Payment_method payment_method);
    Payment_method UpdatePayment_methodById(Long id,Payment_method payment_methodUpdate);

}
