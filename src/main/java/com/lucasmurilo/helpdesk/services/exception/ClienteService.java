package com.lucasmurilo.helpdesk.services.exception;


import com.lucasmurilo.helpdesk.dtos.ClienteDTO;
import com.lucasmurilo.helpdesk.entities.Cliente;
import com.lucasmurilo.helpdesk.entities.Pessoa;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.repositories.ClienteRepository;
import com.lucasmurilo.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;
    
    @Autowired
    private PessoaRepository pessoaRepository;


    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", verifque!" + Cliente.class.getName()
        ));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public ClienteDTO insert(ClienteDTO objDTO) {
        if(findByCPF(objDTO) != null){
            throw new DateIntegrityViolationException("O cpf já esta cadastrado! Verifique o cpf!");
        }
        return new ClienteDTO(repository.save(new Cliente(null,objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone())));
    }

    private Pessoa findByCPF(ClienteDTO objDTO) {
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if(obj != null){
            return obj;
        }
        return null;
    }

    public ClienteDTO update(ClienteDTO objDTO, Integer id) {
        Cliente obj = findById(id);
        if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() !=id){
            throw new DateIntegrityViolationException("O cpf já esta cadastrado! Verifique o cpf!");
        }

        obj.setNome(objDTO.getNome());
        obj.setCpf(objDTO.getCpf());
        obj.setTelefone(obj.getTelefone());
        return new ClienteDTO(repository.save(obj));
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if(obj.getList().size() > 0){
            throw new DateIntegrityViolationException("O Cliente possui ordem de serviços associados! Não pode ser deletado!");
        }
        repository.delete(obj);
    }
}
