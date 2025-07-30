package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.module.Shipment;

import java.util.List;

public interface ShipmentService {

    List<Shipment> getAllShipment();

    Shipment getShipmentById(Long id);
    Shipment deleteShipmentById(Long id);
    Shipment addShipmentById(Shipment shipment);
    Shipment UpdateShipmentById(Long id,Shipment shipmentUpdate);
}
