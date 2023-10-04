package com.viniciuselias.projetotcc.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.viniciuselias.projetotcc.model.dto.OrderDTO;
import com.viniciuselias.projetotcc.model.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@Getter @Setter
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private Long id;

    private OrderStatus orderStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT-3")
    private LocalDateTime moment;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems = new HashSet();

    public Order(OrderStatus orderStatus, LocalDateTime moment) {
        this.orderStatus = orderStatus;
        this.moment = moment;
    }

    public Order(OrderDTO orderDTO) {
        this.orderStatus = orderDTO.orderStatus();
        this.moment = orderDTO.moment();
        this.orderItems = orderDTO.orderItems();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        for(OrderItem item : orderItems) {
            if(orderStatus == OrderStatus.CANCELED && this.orderStatus != OrderStatus.CANCELED){
                item.getProduct().includeProductInStock(item.getQuantity());
            }
        }
        this.orderStatus = orderStatus;
    }

    public Double getTotal() {
        double total = 0.0;

        for(OrderItem i: orderItems) {
            total += i.getSubTotal();
        }

        return total;
    }

}
