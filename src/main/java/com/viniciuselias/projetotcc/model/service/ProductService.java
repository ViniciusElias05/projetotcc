package com.viniciuselias.projetotcc.model.service;

import com.viniciuselias.projetotcc.model.entity.Product;
import com.viniciuselias.projetotcc.model.repositories.ProductRepository;
import com.viniciuselias.projetotcc.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repo.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado"));
    }

    public void insert(Product product) {
        repo.save(product);
    }

}
