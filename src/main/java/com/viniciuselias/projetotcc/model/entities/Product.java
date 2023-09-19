package com.viniciuselias.projetotcc.model.entities;

import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    private String name;
    private Double price;

    private Integer quantity;
    private String description;

    public Product(ProductDTO productDTO) {

        this.id = productDTO.id();
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.quantity = productDTO.quantity();
        this.description = productDTO.description();
    }

}
