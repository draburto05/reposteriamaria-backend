package com.antonieta.MariaSpring.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderShipmentRequest {

    private String address;
    private Long no_seguimiento;
    private String status;
}
