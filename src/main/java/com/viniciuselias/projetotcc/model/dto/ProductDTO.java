package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.entities.Product;

import java.util.HashSet;
import java.util.Set;

public record ProductDTO(Long id, String name, Double price, Integer quantity,
                         String description, Set<Category> categories) {

    public ProductDTO(Product product) {
        this(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantity(),
            product.getDescription(),
            product.getCategories()
        );
    }
}
