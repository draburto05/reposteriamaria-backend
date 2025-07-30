package com.antonieta.MariaSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderProductRequest {
    private String name;
    private Double price;
    private Long stock;
    private String tamanio;
    private String sabor;
}
