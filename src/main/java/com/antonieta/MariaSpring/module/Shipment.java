package com.antonieta.MariaSpring.module;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="shipment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shipment {

    @Id //Marca el campo como clave primaria de la entidad.
    //Es obligatorio en cualquier clase que represente una tabla en la base de datos.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    * Indica que el valor de la clave primaria será generado automáticamente por la base de datos.
La estrategia IDENTITY significa que el campo se auto-incrementa, como en MySQL con AUTO_INCREMENT.
Es útil cuando no quieres asignar manualmente el ID de cada registro.
    * */
    @Column(name="idshipment", unique=true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Long no_seguimiento;
    @Column(nullable = false)
    private String status;




    @OneToOne
    @JoinColumn(name="order_buyid", nullable=false)
    @JsonIgnore
    private Order_buy order_buy;

}
