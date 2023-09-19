package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Category;

public record CategoryDTO(Long id, String name) {

    public CategoryDTO(Category category) {
        this(
                category.getId(),
                category.getName()
        );
    }
}
