package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import com.viniciuselias.projetotcc.model.entities.Product;
import com.viniciuselias.projetotcc.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insert(@RequestBody ProductDTO productDTO) {
        service.insert(productDTO);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return service.update(id, productDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
