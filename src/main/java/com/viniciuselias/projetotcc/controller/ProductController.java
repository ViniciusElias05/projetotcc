package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import com.viniciuselias.projetotcc.model.entity.Product;
import com.viniciuselias.projetotcc.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> list = service.findAll().stream().map(ProductDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ProductDTO productDTO) {
        Product product = new Product(productDTO);
        service.insert(product);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
