package com.senai.S7M2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "nutricionista")
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String crn;
    private String especialidade;
    private String nome;
    private int anosDeExperiencia;
    private List<String> certificacoes;

    // Empty constructor
    public Nutricionista() {
    }

    // All-args constructor
    public Nutricionista(Long id, String crn, String especialidade, String nome, int anosDeExperiencia, List<String> certificacoes) {
        this.id = id;
        this.crn = crn;
        this.especialidade = especialidade;
        this.nome = nome;
        this.anosDeExperiencia = anosDeExperiencia;
        this.certificacoes = certificacoes;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {

    }
}