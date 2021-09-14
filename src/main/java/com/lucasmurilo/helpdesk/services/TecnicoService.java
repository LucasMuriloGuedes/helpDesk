package com.lucasmurilo.helpdesk.services;

import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.repositories.TecnicoRepository;
import com.lucasmurilo.helpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encotrado! Id: " + id + ", Classe: " + Tecnico.class.getName()
        ));
    }
}
