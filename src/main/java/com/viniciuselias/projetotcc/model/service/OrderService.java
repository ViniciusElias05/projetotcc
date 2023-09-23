package com.viniciuselias.projetotcc.model.service;

import com.viniciuselias.projetotcc.model.dto.OrderDTO;
import com.viniciuselias.projetotcc.model.entities.Order;
import com.viniciuselias.projetotcc.model.entities.OrderItem;
import com.viniciuselias.projetotcc.model.repositories.OrderItemRepository;
import com.viniciuselias.projetotcc.model.repositories.OrderRepository;
import com.viniciuselias.projetotcc.model.service.exceptions.DatabaseException;
import com.viniciuselias.projetotcc.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private OrderItemRepository OrderItemRepository;

    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(OrderDTO::new).toList();
    }

    public OrderDTO findById(Long id) {
        return repository.findById(id).map(prod -> new OrderDTO(prod))
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    public void insert(OrderDTO orderDTO) {
        Order order = repository.save(new Order(orderDTO));
    }
    public OrderDTO update(Long id, OrderDTO orderDTO) {
       return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setMoment(orderDTO.moment());
                    recordFound.setOrderStatus(orderDTO.orderStatus());
                    recordFound.setOrderItems(orderDTO.orderItems());
                    return repository.save(recordFound);
                })
               .map(prod -> new OrderDTO(prod))
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
