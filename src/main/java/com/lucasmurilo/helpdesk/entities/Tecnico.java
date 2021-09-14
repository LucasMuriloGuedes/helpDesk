package com.lucasmurilo.helpdesk.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Tecnico extends Pessoa implements Serializable {

    @OneToMany(mappedBy = "tecnico")
    @JsonIgnore
    private List<OrdemServico> list = new ArrayList<>();

    public Tecnico() {
    }

    public Tecnico(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    public List<OrdemServico> getList() {
        return list;
    }
}
