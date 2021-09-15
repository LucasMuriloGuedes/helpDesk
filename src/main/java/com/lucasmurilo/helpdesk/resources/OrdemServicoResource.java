package com.lucasmurilo.helpdesk.resources;

import com.lucasmurilo.helpdesk.dtos.OrdemServicoDTO;
import com.lucasmurilo.helpdesk.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/ordemservicos")
public class OrdemServicoResource {

    @Autowired
    private OrdemServicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdemServicoDTO> findByid(@PathVariable Integer id){
        OrdemServicoDTO obj = new OrdemServicoDTO(service.findById(id));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoDTO>> findAll(){
        List<OrdemServicoDTO> list = service.findAll().stream().map(obj -> new OrdemServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<OrdemServicoDTO> insert(@Valid @RequestBody OrdemServicoDTO objDTO){
        objDTO = new OrdemServicoDTO(service.insert(objDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(objDTO);

    }
}
