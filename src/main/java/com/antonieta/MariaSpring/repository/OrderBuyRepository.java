package com.antonieta.MariaSpring.repository;

import com.antonieta.MariaSpring.module.Order_buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderBuyRepository  extends JpaRepository<Order_buy, Long> {

}


