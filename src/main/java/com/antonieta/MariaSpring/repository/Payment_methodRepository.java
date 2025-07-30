package com.antonieta.MariaSpring.repository;

import com.antonieta.MariaSpring.module.Payment_method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Payment_methodRepository extends JpaRepository<Payment_method, Long> {
}
