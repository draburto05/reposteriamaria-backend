package com.antonieta.MariaSpring.repository;

import com.antonieta.MariaSpring.module.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository  extends JpaRepository<Shipment, Long> {
}
