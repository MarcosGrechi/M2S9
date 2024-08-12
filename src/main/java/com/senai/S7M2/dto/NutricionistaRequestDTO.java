package com.senai.S7M2.dto;

import com.senai.S7M2.model.Nutricionista;

import java.util.List;

public class NutricionistaRequestDTO {
    private String crn;
    private String especialidade;
    private String nome;
    private int AnosdeExperiencia;
    private List<String> certificacoes;

    public NutricionistaRequestDTO() {
    }

    public NutricionistaRequestDTO(String crn, String especialidade, String nome, int AnosdeExperiencia, List<String> certificacoes) {
        this.crn = crn;
        this.especialidade = especialidade;
        this.nome = nome;
        this.AnosdeExperiencia = AnosdeExperiencia;
        this.certificacoes = certificacoes;
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

    public int getAnosdeExperiencia() {
        return AnosdeExperiencia;
    }

    public void setAnosdeExperiencia(int anosdeExperiencia) {
        this.AnosdeExperiencia = anosdeExperiencia;
    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public Nutricionista toEntity() {
        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setCrn(this.crn);
        nutricionista.setEspecialidade(this.especialidade);
        nutricionista.setNome(this.nome);
        nutricionista.setAnosDeExperiencia(this.AnosdeExperiencia);
        nutricionista.setCertificacoes(this.certificacoes);
        return nutricionista;
    }
}