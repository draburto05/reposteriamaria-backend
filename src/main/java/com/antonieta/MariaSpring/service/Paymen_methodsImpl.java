package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.module.Order_buy;
import com.antonieta.MariaSpring.module.Payment_method;
import com.antonieta.MariaSpring.repository.Payment_methodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Paymen_methodsImpl implements Payment_MethodService{

    private final Payment_methodRepository paymentMethodRepository;

    @Autowired
    public Paymen_methodsImpl(Payment_methodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<Payment_method> getAllPayment_method() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public Payment_method getPayment_methodById(Long id) {
        return paymentMethodRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("El método de pago con el id " + id+ " no existe")

        );
    }

    @Override
    public Payment_method deletePayment_methodById(Long id) {
        Payment_method tmp = null;
        //Usamos early return para evaluar si no existe el prodcuto
        //en caso de que no existe, terminamos la ejecucion de la funcion
        //en ese momennto
        if(!paymentMethodRepository.existsById(id))return tmp;
        //si el producto existe, guardamos el producto en la variable temporal
        tmp= paymentMethodRepository.findById(id).get();
        //eliminamos el producto
        paymentMethodRepository.deleteById(id);
        //retornamos el producto eliminado
        return tmp;
    }

    @Override
    public Payment_method addPayment_methodById(Payment_method payment_method) {
        return paymentMethodRepository.save(payment_method);
    }

    @Override
    public Payment_method UpdatePayment_methodById(Long id, Payment_method payment_methodUpdate) {
        Optional<Payment_method> optionalPaymentMethod = paymentMethodRepository.findById(id);
        if(optionalPaymentMethod.isEmpty())throw
                new IllegalArgumentException("El método de pago con el id " + id+ " no existe");
       Payment_method originalpayment_order = optionalPaymentMethod.get();
        //Evaluar el producto que hara cambio evaluando propiedades y solo donde no esten vacias se aplican cambios
        if(payment_methodUpdate.getType() !=null) originalpayment_order.setType(payment_methodUpdate.getType());
        return paymentMethodRepository.save(originalpayment_order);
    }


}
