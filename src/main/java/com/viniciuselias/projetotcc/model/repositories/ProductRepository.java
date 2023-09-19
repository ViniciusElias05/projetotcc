package com.viniciuselias.projetotcc.model.repositories;

import com.viniciuselias.projetotcc.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
