package com.lucasmurilo.helpdesk.repositories;

import com.lucasmurilo.helpdesk.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
