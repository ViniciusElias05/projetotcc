package com.viniciuselias.projetotcc.config;

import com.viniciuselias.projetotcc.model.entities.*;
import com.viniciuselias.projetotcc.model.entities.enums.OrderStatus;
import com.viniciuselias.projetotcc.model.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        orderItemRepository.deleteAll();
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        orderRepository.deleteAll();
        clientRepository.deleteAll();

        Product p1 = new Product(null, "Televisão", 1200.00, 12, "Smart Tv 40 polegadas");
        Product p2 = new Product(null, "Smartphone", 1800.00, 30, "Samsung a51 ");
        Product p3 = new Product(null, "Notebook", 2700.00, 15, "Dell inspirion i7");


        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Category c1 = new Category(null, "eletrônico");
        Category c2 = new Category(null, "eletrodoméstico");

        categoryRepository.saveAll(Arrays.asList(c1, c2));

        p1.getCategories().addAll(Arrays.asList(c1, c2));
        p2.getCategories().add(c1);
        p3.getCategories().add(c1);

        Client client1 = new Client(null, "Lojas x", "1234567", "lojasx@gmail.com", "Rua a, n° 21");
        Client client2 = new Client(null, "Lojas y", "1234568", "lojasy@gmail.com", "Rua b, n° 22");
        Client client3 = new Client(null, "Lojas z", "1234569", "lojasz@gmail.com", "Rua c, n° 23");

        clientRepository.saveAll(Arrays.asList(client1, client2, client3));

        Order o1 = new Order(OrderStatus.WAITING_PAYMENT, LocalDateTime.now(), client1);
        Order o2 = new Order(OrderStatus.PAID, LocalDateTime.now(), client2);
        Order o3 = new Order(OrderStatus.CANCELED, LocalDateTime.now(), client3);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(null, 10, p1, o1);
        OrderItem oi2 = new OrderItem(null, 5, p2, o2);
        OrderItem oi3 = new OrderItem(null, 3, p3, o3);
        OrderItem oi4 = new OrderItem(null, 2, p3, o1);

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));



    }
}
