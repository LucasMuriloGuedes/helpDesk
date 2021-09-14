package com.lucasmurilo.helpdesk.services;

import com.lucasmurilo.helpdesk.dtos.TecnicoDTO;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.repositories.TecnicoRepository;
import com.lucasmurilo.helpdesk.services.exception.DateIntegrityViolationException;
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
        if(findByCPF(objDTO) != null){
            throw new DateIntegrityViolationException("Cpf ja cadastrado na base de dados");
        }
       return new TecnicoDTO(repository.save( new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone())));

    }
    private Tecnico findByCPF(TecnicoDTO objDTO){
        Tecnico obj = repository.findByCPF(objDTO.getCpf());
        if(obj != null){
            return obj;
        }
        return null;
    }

    public TecnicoDTO update(TecnicoDTO tecnicoDTO, Integer id) {
        Tecnico obj = findById(id);
        if(findByCPF(tecnicoDTO) != null && findByCPF(tecnicoDTO).getId() != id){
            throw new DateIntegrityViolationException("Cpf ja cadastrado na base de dados");
        }
        obj.setNome(tecnicoDTO.getNome());
        obj.setCpf(tecnicoDTO.getCpf());
        obj.setTelefone(tecnicoDTO.getTelefone());
        return new TecnicoDTO(repository.save(obj));
    }
}
