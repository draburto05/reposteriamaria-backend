package com.antonieta.MariaSpring.repository;

import com.antonieta.MariaSpring.module.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
