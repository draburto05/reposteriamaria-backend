package com.antonieta.MariaSpring.service;

import com.antonieta.MariaSpring.module.Order_buy;
import com.antonieta.MariaSpring.module.Shipment;
import com.antonieta.MariaSpring.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public List<Shipment> getAllShipment() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("El Envio con el id " + id+ " no existe")

        );
    }

    @Override
    public Shipment deleteShipmentById(Long id) {
        Shipment tmp = null;
        //Usamos early return para evaluar si no existe el prodcuto
        //en caso de que no existe, terminamos la ejecucion de la funcion
        //en ese momennto
        if(!shipmentRepository.existsById(id))return tmp;
        //si el producto existe, guardamos el producto en la variable temporal
        tmp= shipmentRepository.findById(id).get();
        //eliminamos el producto
        shipmentRepository.deleteById(id);
        //retornamos el producto eliminado
        return tmp;
    }

    @Override
    public Shipment addShipmentById(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment UpdateShipmentById(Long id, Shipment shipmentUpdate) {
        Optional<Shipment> optionalShipment = shipmentRepository.findById(id);
        if(optionalShipment.isEmpty())throw
                new IllegalArgumentException("El envio con el id " + id+ " no existe");
        Shipment originalshipment= optionalShipment.get();
        //Evaluar el producto que hara cambio evaluando propiedades y solo donde no esten vacias se aplican cambios
        if(shipmentUpdate.getAddress() !=null) originalshipment.setAddress(shipmentUpdate.getAddress());
        if(shipmentUpdate.getNo_seguimiento() !=null) originalshipment.setNo_seguimiento(shipmentUpdate.getNo_seguimiento());
        if(shipmentUpdate.getStatus() !=null) originalshipment.setStatus(shipmentUpdate.getStatus());
        return shipmentRepository.save(shipmentUpdate);

    }


}
