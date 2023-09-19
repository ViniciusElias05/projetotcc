package com.viniciuselias.projetotcc.model.entities;

import com.viniciuselias.projetotcc.model.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category {

    @Setter(AccessLevel.PRIVATE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(CategoryDTO categoryDTO){
        id = categoryDTO.id();
        name = categoryDTO.name();
    }

}
