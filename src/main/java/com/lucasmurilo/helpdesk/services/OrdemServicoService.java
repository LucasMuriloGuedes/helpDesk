package com.lucasmurilo.helpdesk.services;

import com.lucasmurilo.helpdesk.entities.OrdemServico;
import com.lucasmurilo.helpdesk.repositories.OrdemServicoRepository;
import com.lucasmurilo.helpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository repository;

    public OrdemServico findById(Integer id){
        Optional<OrdemServico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + OrdemServicoService.class.getName()
        ));
    }
}
