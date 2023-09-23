package com.viniciuselias.projetotcc.model.dto;

import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.entities.Order;
import com.viniciuselias.projetotcc.model.entities.OrderItem;
import com.viniciuselias.projetotcc.model.entities.Product;
import com.viniciuselias.projetotcc.model.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public record OrderDTO(Long id, OrderStatus orderStatus, LocalDateTime moment,
                       Set<OrderItem> orderItems, Double Total) {

    public OrderDTO(Order order) {
        this(
                order.getId(),
                order.getOrderStatus(),
                order.getMoment(),
                order.getOrderItems(),
                order.getTotal()
        );
    }
}
