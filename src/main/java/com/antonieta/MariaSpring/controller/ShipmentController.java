package com.antonieta.MariaSpring.controller;


import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.module.Order_buy;
import com.antonieta.MariaSpring.module.Products;
import com.antonieta.MariaSpring.module.Shipment;
import com.antonieta.MariaSpring.service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/shipment")
@AllArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getAllShipment() {
        return shipmentService.getAllShipment();
    }

    @GetMapping("/{shipmentId}")
    public Shipment getShipmentById(@PathVariable("shipmentId") Long id) {
        return shipmentService.getShipmentById(id);
    }

    @PostMapping
    public Shipment addShipment(@RequestBody Shipment shipment) {
        return shipmentService.addShipmentById(shipment);
    }

    @DeleteMapping("/{shipmentId}")
    public Shipment deleteShipmentById(@PathVariable("shipmentId") Long id) {
        return shipmentService.deleteShipmentById(id);
    }
    // Petición put
    @PutMapping("/{shipmentId}")
    public Shipment updateShipmentById(@PathVariable("shipmentId") Long id, @RequestBody Shipment shipmentUpdated) {
        return shipmentService.UpdateShipmentById(id, shipmentUpdated);
    }






}