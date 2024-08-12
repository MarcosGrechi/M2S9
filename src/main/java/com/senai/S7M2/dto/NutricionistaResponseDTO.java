package com.senai.S7M2.dto;

import com.senai.S7M2.model.Nutricionista;

import java.util.List;

public class NutricionistaResponseDTO {
    private Long id;
    private String crn;
    private String especialidade;
    private String nome;
    private int anosDeExperiencia
            ;
    private List<String> certificacoes;

    public NutricionistaResponseDTO() {
    }

    public NutricionistaResponseDTO(Long id, String crn, String especialidade, String nome, int AnosDe, List<String> certificacoes) {
        this.id = id;
        this.crn = crn;
        this.especialidade = especialidade;
        this.nome = nome;
        this.anosDeExperiencia = AnosDe;
        this.certificacoes = certificacoes;
    }

    public NutricionistaResponseDTO(Nutricionista nutricionista) {
    }

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

    public int getAnosDe() {
        return anosDeExperiencia;
    }

    public void setAnosDe(int anosDeExperiencia) {
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }
}