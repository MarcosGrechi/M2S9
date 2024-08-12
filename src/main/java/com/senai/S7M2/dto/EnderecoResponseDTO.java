package com.senai.S7M2.dto;

import com.senai.S7M2.model.Endereco;

public class EnderecoResponseDTO {
    private Long id;
    private String logradouro;
    private String estado;
    private String cidade;
    private String numero;
    private String cep;

    public EnderecoResponseDTO() {
    }

    public EnderecoResponseDTO(Long id, String logradouro, String estado, String cidade, String numero, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.estado = estado;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }
    public EnderecoResponseDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.logradouro = endereco.getLogradouro();
        this.estado = endereco.getEstado();
        this.cidade = endereco.getCidade();
        this.numero = endereco.getNumero();
        this.cep = endereco.getCep();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}