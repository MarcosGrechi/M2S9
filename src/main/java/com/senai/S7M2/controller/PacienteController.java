package com.senai.S7M2.controller;

import com.senai.S7M2.dto.EnderecoResponseDTO;
import com.senai.S7M2.dto.PacienteRequestDTO;
import com.senai.S7M2.dto.PacienteResponseDTO;
import com.senai.S7M2.model.Paciente;
import com.senai.S7M2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> createPaciente(@RequestBody PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = pacienteService.createPaciente(pacienteRequestDTO.toEntity());
        return ResponseEntity.ok(new PacienteResponseDTO(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), new EnderecoResponseDTO(paciente.getEndereco())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> updatePaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = pacienteRequestDTO.toEntity();
        paciente.setId(id);
        Paciente updatedPaciente = pacienteService.updatePaciente(paciente);
        return ResponseEntity.ok(new PacienteResponseDTO(updatedPaciente.getId(), updatedPaciente.getNome(), updatedPaciente.getCpf(), updatedPaciente.getEmail(), updatedPaciente.getTelefone(), new EnderecoResponseDTO(updatedPaciente.getEndereco())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        List<PacienteResponseDTO> pacienteResponseDTOS = pacientes.stream().map(paciente -> new PacienteResponseDTO(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), new EnderecoResponseDTO(paciente.getEndereco()))).collect(Collectors.toList());
        return ResponseEntity.ok(pacienteResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> getPacienteById(@PathVariable Long id) {
        Paciente paciente = pacienteService.getPacienteById(id);
        return ResponseEntity.ok(new PacienteResponseDTO(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), new EnderecoResponseDTO(paciente.getEndereco())));
    }
}