package com.senai.S7M2.service;

import com.senai.S7M2.model.Paciente;
import com.senai.S7M2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
}