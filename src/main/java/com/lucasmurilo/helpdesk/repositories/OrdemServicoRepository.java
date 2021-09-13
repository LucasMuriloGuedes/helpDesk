package com.lucasmurilo.helpdesk.repositories;

import com.lucasmurilo.helpdesk.entities.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
}
