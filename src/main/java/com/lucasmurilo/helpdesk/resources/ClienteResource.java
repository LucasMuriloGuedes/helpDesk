package com.lucasmurilo.helpdesk.resources;

import com.lucasmurilo.helpdesk.dtos.ClienteDTO;
import com.lucasmurilo.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new ClienteDTO(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findByid(){
        return ResponseEntity.ok().body(service.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO objDTO){
        objDTO = service.insert(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(objDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO objDTO){
        objDTO = service.update(objDTO, id);
        return ResponseEntity.ok().body(objDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
