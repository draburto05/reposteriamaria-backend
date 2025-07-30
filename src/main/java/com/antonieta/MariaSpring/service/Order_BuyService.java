package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.dto.OrderShipmentRequest;
import com.antonieta.MariaSpring.module.Order_buy;

import java.util.List;

public interface Order_BuyService {



    List<Order_buy> getAllOrder_buy();

    Order_buy getOrder_buyById(Long id);
    Order_buy deleteOrder_buyById(Long id);
    Order_buy addOrder_buyById(Order_buy order_buy);
    Order_buy UpdateOrder_buyById(Long id,Order_buy order_buyUpdate);

    Order_buy addOrderProduct(Long id, OrderProductRequest orderProductRequest);

    Order_buy addOrderShipment(Long id, OrderShipmentRequest orderShipmentRequest);
}
