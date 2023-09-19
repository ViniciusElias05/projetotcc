package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Product;

public record ProductDTO(Long id, String name, Double price, Integer quantity, String description) {
    public ProductDTO(Product product) {
        this(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantity(),
            product.getDescription()
        );
    }
}
