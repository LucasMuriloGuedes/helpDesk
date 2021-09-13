package com.lucasmurilo.helpdesk.repositories;

import com.lucasmurilo.helpdesk.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
