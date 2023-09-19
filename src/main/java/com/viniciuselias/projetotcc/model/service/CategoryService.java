package com.viniciuselias.projetotcc.model.service;

import com.viniciuselias.projetotcc.model.dto.CategoryDTO;
import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.repositories.CategoryRepository;
import com.viniciuselias.projetotcc.model.service.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<CategoryDTO> findAll() {
        return repository.findAll().stream().map(obj -> new CategoryDTO(obj)).toList();
    }

    public CategoryDTO findById(Long id) {
        return repository.findById(id).map(cat -> new CategoryDTO(cat))
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void insert(Category category) {
        repository.save(category);
    }
    public CategoryDTO update(Long id, Category category) {
       return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(category.getName());
                    return repository.save(recordFound);
                })
               .map(cat -> new CategoryDTO(cat))
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
