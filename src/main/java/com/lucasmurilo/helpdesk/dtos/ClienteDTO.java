package com.lucasmurilo.helpdesk.dtos;

import com.lucasmurilo.helpdesk.entities.Cliente;
import com.lucasmurilo.helpdesk.entities.Tecnico;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @CPF
    private String cpf;
    @NotEmpty(message = "O campo telefone é obrigatório")
    private String telefone;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
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
