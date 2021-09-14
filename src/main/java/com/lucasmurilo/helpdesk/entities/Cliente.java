package com.lucasmurilo.helpdesk.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<OrdemServico> list = new ArrayList<>();

    public Cliente() {
    }
    public Cliente(Integer id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    public List<OrdemServico> getList() {
        return list;
    }
}
