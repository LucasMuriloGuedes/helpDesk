package com.lucasmurilo.helpdesk.dtos;

import com.lucasmurilo.helpdesk.entities.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class TecnicoDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @CPF
    private String cpf;
    @NotEmpty(message = "O campo telefone é obrigatório")
    private String telefone;

    public TecnicoDTO() {
    }

    public TecnicoDTO(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.telefone = tecnico.getTelefone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
