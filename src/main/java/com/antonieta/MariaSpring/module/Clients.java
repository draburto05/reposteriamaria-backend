package com.antonieta.MariaSpring.module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Clients {
    @Id//Marca el campo como clave primaria de la entidad.
    //Es obligatorio en cualquier clase que represente una tabla en la base de datos.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      /*
    * Indica que el valor de la clave primaria será generado automáticamente por la base de datos.
La estrategia IDENTITY significa que el campo se auto-incrementa, como en MySQL con AUTO_INCREMENT.
Es útil cuando no quieres asignar manualmente el ID de cada registro.
    * */


    @Column(name="idcliente", unique=true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String lastName2;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private String address;



    @OneToMany(mappedBy = "client", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Order_buy> order_buys;


}
