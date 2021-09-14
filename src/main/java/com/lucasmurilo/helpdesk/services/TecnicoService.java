package com.lucasmurilo.helpdesk.services;

import com.lucasmurilo.helpdesk.dtos.TecnicoDTO;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.repositories.TecnicoRepository;
import com.lucasmurilo.helpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public TecnicoDTO insert(TecnicoDTO objDTO) {
       return new TecnicoDTO(repository.save( new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone())));

    }
}
