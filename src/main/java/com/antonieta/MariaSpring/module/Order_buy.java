package com.antonieta.MariaSpring.module;


import com.antonieta.MariaSpring.dto.OrderProductRequest;
import com.antonieta.MariaSpring.repository.OrderBuyRepository;
import com.antonieta.MariaSpring.repository.ShipmentRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_buy" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order_buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String tipo_entrega;


    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    @JsonIgnore
    private Clients client;







    @OneToOne(mappedBy = "order_buy", cascade=CascadeType.ALL, orphanRemoval = true)
    private Shipment shipment;



    @OneToMany(mappedBy = "order_buy", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Products> products;




}
