package com.viniciuselias.projetotcc.config;

import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.entities.Product;
import com.viniciuselias.projetotcc.model.repositories.CategoryRepository;
import com.viniciuselias.projetotcc.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        productRepository.deleteAll();
        categoryRepository.deleteAll();

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

        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
