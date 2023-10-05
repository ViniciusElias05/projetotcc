package com.viniciuselias.projetotcc.model.repositories;

import com.viniciuselias.projetotcc.model.entities.Category;
import com.viniciuselias.projetotcc.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
