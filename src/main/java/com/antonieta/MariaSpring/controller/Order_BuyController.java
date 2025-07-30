package com.antonieta.MariaSpring.controller;


import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.dto.OrderShipmentRequest;
import com.antonieta.MariaSpring.module.Order_buy;
import com.antonieta.MariaSpring.service.Order_BuyService;
import com.antonieta.MariaSpring.service.ProductsService;
import com.antonieta.MariaSpring.service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//vamos a usar este controlador para llamar a la API
@RequestMapping(path="/api/orderBuy")

@AllArgsConstructor
public class Order_BuyController {

    private Order_BuyService order_buyService;


    @GetMapping //http://localhost:8080/api/users
    public List<Order_buy> getAllOrder_Buy() {

        return this.order_buyService.getAllOrder_buy();
    }

    @GetMapping(path = "{order_buyId}")
    public Order_buy getOrder_BuyById(@PathVariable("order_buyId") Long id) {
        return this.order_buyService.getOrder_buyById(id);

    }

    @PostMapping
    public Order_buy addOrder_Buy(@RequestBody Order_buy order_buy) {
        return this.order_buyService.addOrder_buyById(order_buy);
    }


    @PutMapping(path = "{Order_buyId}")
    public Order_buy updateOrder_buyId(@PathVariable("order_buyId") Long id, @RequestBody Order_buy order_buyUpdated) {
        return this.order_buyService.UpdateOrder_buyById(id, order_buyUpdated);
    }


    //peticion para agregar producto
    @PostMapping(path = "{Order_buyId}/add-product")//http://localhost:8080/api/users/userId/add-direction
    public Order_buy addProduct(@PathVariable("Order_buyId") Long id, @RequestBody OrderProductRequest orderProductRequest) {
        return order_buyService.addOrderProduct(id, orderProductRequest);
    }

    @PostMapping(path = "{Order_buyId}/add-shipment")//http://localhost:8080/api/users/userId/add-direction
    public Order_buy addShipment(@PathVariable("Order_buyId") Long id, @RequestBody OrderShipmentRequest orderShipmentRequest) {
        return order_buyService.addOrderShipment(id, orderShipmentRequest);
    }
}
