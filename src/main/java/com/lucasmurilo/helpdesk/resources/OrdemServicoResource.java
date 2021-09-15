package com.lucasmurilo.helpdesk.resources;

import com.lucasmurilo.helpdesk.dtos.OrdemServicoDTO;
import com.lucasmurilo.helpdesk.services.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
