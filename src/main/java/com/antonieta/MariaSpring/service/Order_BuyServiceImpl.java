package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.dto.OrderShipmentRequest;
import com.antonieta.MariaSpring.module.Order_buy;
import com.antonieta.MariaSpring.module.Products;
import com.antonieta.MariaSpring.module.Shipment;
import com.antonieta.MariaSpring.repository.OrderBuyRepository;
import com.antonieta.MariaSpring.repository.ProductsRepository;
import com.antonieta.MariaSpring.repository.ShipmentRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Order_BuyServiceImpl implements Order_BuyService{

    private final OrderBuyRepository orderBuyRepository;
    private final ProductsRepository productsRepository;
    private final ShipmentRepository shipmentRepository;

    @Autowired
    public Order_BuyServiceImpl(OrderBuyRepository orderBuyRepository, ProductsRepository productsRepository, ShipmentRepository shipmentRepository) {
        this.orderBuyRepository = orderBuyRepository;
        this.productsRepository = productsRepository;
        this.shipmentRepository = shipmentRepository;
    }


    @Override
    public List<Order_buy> getAllOrder_buy() {
        return orderBuyRepository.findAll();
    }

    @Override
    public Order_buy getOrder_buyById(Long id) {
        return orderBuyRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("El Pedido con el id " + id+ " no existe")

        );
    }

    @Override
    public Order_buy deleteOrder_buyById(Long id) {
        Order_buy tmp = null;
        //Usamos early return para evaluar si no existe el prodcuto
        //en caso de que no existe, terminamos la ejecucion de la funcion
        //en ese momennto
        if(!orderBuyRepository.existsById(id))return tmp;
        //si el producto existe, guardamos el producto en la variable temporal
        tmp= orderBuyRepository.findById(id).get();
        //eliminamos el producto
        orderBuyRepository.deleteById(id);
        //retornamos el producto eliminado
        return tmp;
    }

    @Override
    public Order_buy addOrder_buyById(Order_buy order_buy) {
        return orderBuyRepository.save(order_buy);
    }

    @Override
    public Order_buy UpdateOrder_buyById(Long id, Order_buy order_buyUpdate) {

        Optional<Order_buy> optionalOrder_buy = orderBuyRepository.findById(id);
        if(optionalOrder_buy.isEmpty())throw
                new IllegalArgumentException("El pedido con el id " + id+ " no existe");
        Order_buy originalorder_buy = optionalOrder_buy.get();
        //Evaluar el producto que hara cambio evaluando propiedades y solo donde no esten vacias se aplican cambios
        if(order_buyUpdate.getFecha() !=null) originalorder_buy.setFecha(order_buyUpdate.getFecha());
        if(order_buyUpdate.getPrice() !=null) originalorder_buy.setPrice(order_buyUpdate.getPrice());
        if(order_buyUpdate.getTipo_entrega() !=null) originalorder_buy.setTipo_entrega(order_buyUpdate.getTipo_entrega());
          return orderBuyRepository.save(originalorder_buy);

    }

    @Override
    public Order_buy addOrderProduct(Long id, OrderProductRequest orderProductRequest) {
            Order_buy order_buy= orderBuyRepository.findById(id).orElseThrow(
                    ()-> new IllegalArgumentException(("El usuario con el id "+id+" no existe")));
            Products product= new Products();
            if(orderProductRequest.getName()!= null) product.setName(orderProductRequest.getName());
            if(orderProductRequest.getPrice()!= null) product.setPrice(orderProductRequest.getPrice());
            if(orderProductRequest.getStock()!= null) product.setStock(orderProductRequest.getStock());
            if(orderProductRequest.getTamanio()!= null) product.setTamanio(orderProductRequest.getTamanio());
            if(orderProductRequest.getSabor()!= null) product.setSabor(orderProductRequest.getSabor());
            product.setOrder_buy(order_buy);
        productsRepository.save(product);
            order_buy.getProducts().add(product);

            return orderBuyRepository.save(order_buy);
        }


@Override
    public Order_buy addOrderShipment(Long id, OrderShipmentRequest orderShipmentRequest) {
        Order_buy order_buy= orderBuyRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException(("El usuario con el id "+id+" no existe")));
        Shipment shipment= new Shipment();
        if(orderShipmentRequest.getAddress()!= null) shipment.setAddress(orderShipmentRequest.getAddress());
        if(orderShipmentRequest.getNo_seguimiento()!= null) shipment.setNo_seguimiento(orderShipmentRequest.getNo_seguimiento());
        if(orderShipmentRequest.getStatus()!= null) shipment.setStatus(orderShipmentRequest.getStatus());
         shipment.setOrder_buy(order_buy);
        shipmentRepository.save(shipment);
    order_buy.setShipment(shipment);

        return orderBuyRepository.save(order_buy);
    }
    }


