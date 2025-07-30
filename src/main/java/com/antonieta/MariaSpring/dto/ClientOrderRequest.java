package com.antonieta.MariaSpring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClientOrderRequest {
    private Date fecha;
    private Double price;
    private String tipo_entrega;
}
