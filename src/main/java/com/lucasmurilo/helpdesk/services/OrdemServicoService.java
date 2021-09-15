package com.lucasmurilo.helpdesk.services;

import com.lucasmurilo.helpdesk.dtos.OrdemServicoDTO;
import com.lucasmurilo.helpdesk.entities.Cliente;
import com.lucasmurilo.helpdesk.entities.OrdemServico;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.entities.enums.Prioridade;
import com.lucasmurilo.helpdesk.entities.enums.Status;
import com.lucasmurilo.helpdesk.repositories.OrdemServicoRepository;
import com.lucasmurilo.helpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository repository;

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private  ClienteService clienteService;

    public OrdemServico findById(Integer id){
        Optional<OrdemServico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", tipo: " + OrdemServicoService.class.getName()
        ));
    }

    public List<OrdemServico> findAll(){
        return repository.findAll();
    }

    public OrdemServico insert(@Valid OrdemServicoDTO obj){
        return fromDTO(obj);

    }

    public OrdemServico update(OrdemServicoDTO obj) {
        findById(obj.getId());
        return fromDTO(obj);
    }

    private OrdemServico fromDTO(OrdemServicoDTO objDTO){
        OrdemServico obj = new OrdemServico();
        obj.setId(objDTO.getId());
        obj.setObservacoes(objDTO.getObservacoes());
        obj.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
        obj.setStatus(Status.toEnum(objDTO.getStatus()));

        Tecnico tec = tecnicoService.findById(objDTO.getTecnico());
        Cliente cli = clienteService.findById(objDTO.getCliente());

        obj.setCliente(cli);
        obj.setTecnico(tec);

        if(obj.getStatus().getCod().equals(2)){
            obj.setDataFechamento(LocalDateTime.now());
        }
        return repository.save(obj);
    }
}
