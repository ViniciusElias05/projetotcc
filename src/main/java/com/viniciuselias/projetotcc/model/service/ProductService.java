package com.viniciuselias.projetotcc.model.service;

import com.viniciuselias.projetotcc.model.entities.Product;
import com.viniciuselias.projetotcc.model.repositories.ProductRepository;
import com.viniciuselias.projetotcc.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void insert(Product product) {
        repo.save(product);
    }

}
