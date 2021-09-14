package com.lucasmurilo.helpdesk.repositories;

import com.lucasmurilo.helpdesk.entities.Pessoa;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository  extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT obj FROM Pessoa obj where obj.cpf =:cpf")
    Pessoa findByCPF(@Param("cpf") String cpf);
}
