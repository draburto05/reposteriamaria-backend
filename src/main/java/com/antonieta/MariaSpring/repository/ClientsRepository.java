package com.antonieta.MariaSpring.repository;


import com.antonieta.MariaSpring.module.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
