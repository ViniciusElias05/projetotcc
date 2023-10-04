package com.viniciuselias.projetotcc.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
@NoArgsConstructor
@Getter @Setter
@ToString
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String description;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_fk"),
            inverseJoinColumns = @JoinColumn(name = "category_fk"))
    private Set<Category> categories = new HashSet();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet();

    public Product(ProductDTO productDTO) {

        this.id = productDTO.id();
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.quantity = productDTO.quantity();
        this.description = productDTO.description();
        this.categories = productDTO.categories();
    }

    public Product(Long id, String name, Double price, Integer quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public void includeProductInStock(Integer quantity){
        this.quantity += quantity;
    }

    public void removeProductInStock(Integer quantity){
        this.quantity -= quantity;
    }
}
