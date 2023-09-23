package com.viniciuselias.projetotcc.controller;

import com.viniciuselias.projetotcc.model.dto.OrderDTO;
import com.viniciuselias.projetotcc.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<OrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public OrderDTO findById(@PathVariable Long id) {
            return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insert(@RequestBody OrderDTO orderDTO) {
        service.insert(orderDTO);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public OrderDTO update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return service.update(id, orderDTO);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
