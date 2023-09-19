package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.CategoryDTO;
import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<CategoryDTO>findAll() {
        return service.findAll();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insert(@RequestBody CategoryDTO categoryDTO) {
        service.insert(new Category(categoryDTO));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        return service.update(id, new Category(categoryDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
