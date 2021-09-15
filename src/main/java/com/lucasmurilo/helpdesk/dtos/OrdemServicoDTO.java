package com.lucasmurilo.helpdesk.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasmurilo.helpdesk.entities.OrdemServico;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class OrdemServicoDTO implements Serializable {

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;;
    private Integer prioridade;
    @NotEmpty(message = "O Campo OBSERVAÇÕES é requerido!")
    private String observacoes;
    private Integer status;
    private Integer tecnico;
    private Integer cliente;

    public OrdemServicoDTO(){

    }

    public OrdemServicoDTO(OrdemServico ordemServico) {
        this.id = id = ordemServico.getId();
        this.dataAbertura = ordemServico.getDataAbertura();
        this.dataFechamento = ordemServico.getDataFechamento();
        this.prioridade = ordemServico.getPrioridade().getCod();
        this.observacoes = ordemServico.getObservacoes();
        this.status = ordemServico.getStatus().getCod();
        this.tecnico = ordemServico.getTecnico().getId();
        this.cliente = ordemServico.getCliente().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTecnico() {
        return tecnico;
    }

    public void setTecnico(Integer tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }
}
