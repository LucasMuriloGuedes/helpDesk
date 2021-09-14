package com.lucasmurilo.helpdesk.resources;

import com.lucasmurilo.helpdesk.dtos.TecnicoDTO;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import com.lucasmurilo.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        TecnicoDTO objDto = new TecnicoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDto);
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> list = service.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> insert(@Valid @RequestBody TecnicoDTO objDTO){
        objDTO = service.insert(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> update(@RequestBody TecnicoDTO tecnicoDTO, @PathVariable Integer id){
        TecnicoDTO objDTO = service.update(tecnicoDTO, id);
        return ResponseEntity.ok().body(objDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
