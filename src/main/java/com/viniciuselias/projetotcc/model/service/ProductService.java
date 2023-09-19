package com.viniciuselias.projetotcc.model.service;

import com.viniciuselias.projetotcc.model.dto.ProductDTO;
import com.viniciuselias.projetotcc.model.entities.Product;
import com.viniciuselias.projetotcc.model.repositories.ProductRepository;
import com.viniciuselias.projetotcc.model.service.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public ProductDTO findById(Long id) {
        return repository.findById(id).map(prod -> new ProductDTO(prod))
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void insert(Product product) {
        repository.save(product);
    }
    public ProductDTO update(Long id, Product product) {
       return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(product.getName());
                    recordFound.setPrice(product.getPrice());
                    recordFound.setQuantity(product.getQuantity());
                    recordFound.setDescription(product.getDescription());
                    return repository.save(recordFound);
                })
               .map(prod -> new ProductDTO(prod))
               .orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public void delete(Long id) {
        try{
            repository.delete(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id)));
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
