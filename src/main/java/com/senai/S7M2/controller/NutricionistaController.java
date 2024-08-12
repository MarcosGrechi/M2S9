package com.senai.S7M2.controller;

import com.senai.S7M2.dto.NutricionistaRequestDTO;
import com.senai.S7M2.dto.NutricionistaResponseDTO;
import com.senai.S7M2.model.Nutricionista;
import com.senai.S7M2.service.NutricionistaService;
import com.senai.S7M2.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

    @Autowired
    private NutricionistaService nutricionistaService;

    private final TokenService tokenService;

    public NutricionistaController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_NUTRI')")

    @PostMapping
    public ResponseEntity<NutricionistaResponseDTO> createNutricionista(@RequestBody NutricionistaRequestDTO nutricionistaRequestDTO) {
        Nutricionista nutricionista = new Nutricionista(null, nutricionistaRequestDTO.getCrn(), nutricionistaRequestDTO.getEspecialidade(), nutricionistaRequestDTO.getNome(), nutricionistaRequestDTO.getAnosdeExperiencia(), nutricionistaRequestDTO.getCertificacoes());
        Nutricionista createdNutricionista = nutricionistaService.createNutricionista(nutricionista);
        return ResponseEntity.ok(new NutricionistaResponseDTO(createdNutricionista.getId(), createdNutricionista.getCrn(), createdNutricionista.getEspecialidade(), createdNutricionista.getNome(), createdNutricionista.getAnosDeExperiencia(), createdNutricionista.getCertificacoes()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutricionistaResponseDTO> updateNutricionista(@PathVariable Long id, @RequestBody NutricionistaRequestDTO nutricionistaRequestDTO) {
        Nutricionista nutricionista = new Nutricionista(id, nutricionistaRequestDTO.getCrn(), nutricionistaRequestDTO.getEspecialidade(), nutricionistaRequestDTO.getNome(), nutricionistaRequestDTO.getAnosdeExperiencia(), nutricionistaRequestDTO.getCertificacoes());
        Nutricionista updatedNutricionista = nutricionistaService.updateNutricionista(nutricionista);
        return ResponseEntity.ok(new NutricionistaResponseDTO(updatedNutricionista.getId(), updatedNutricionista.getCrn(), updatedNutricionista.getEspecialidade(), updatedNutricionista.getNome(), updatedNutricionista.getAnosDeExperiencia(), updatedNutricionista.getCertificacoes()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNutricionista(@PathVariable Long id) {
        nutricionistaService.deleteNutricionista(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NutricionistaResponseDTO>> getAllNutricionistas(
            @RequestHeader(name="Authorization") String token) {
        tokenService.validaToken(token, "NUTRI");
        List<Nutricionista> nutricionistas = nutricionistaService.getAllNutricionistas();
        List<NutricionistaResponseDTO> nutricionistaResponseDTOS = nutricionistas.stream().map(nutricionista -> new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getCrn(), nutricionista.getEspecialidade(), nutricionista.getNome(), nutricionista.getAnosDeExperiencia(), nutricionista.getCertificacoes())).collect(Collectors.toList());
        return ResponseEntity.ok(nutricionistaResponseDTOS);


    }

    @GetMapping("/{id}")
    public ResponseEntity<NutricionistaResponseDTO> getNutricionistaById(@PathVariable Long id) {
        Nutricionista nutricionista = nutricionistaService.getNutricionistaById(id);
        return ResponseEntity.ok(new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getCrn(), nutricionista.getEspecialidade(), nutricionista.getNome(), nutricionista.getAnosDeExperiencia(), nutricionista.getCertificacoes()));
    }

    @PatchMapping("/{id}/experience")
    public ResponseEntity<NutricionistaResponseDTO> addYearToExperience(@PathVariable Long id) {
        Nutricionista updatedNutricionista = nutricionistaService.addYearToExperience(id);
        return ResponseEntity.ok(new NutricionistaResponseDTO(updatedNutricionista.getId(), updatedNutricionista.getCrn(), updatedNutricionista.getEspecialidade(), updatedNutricionista.getNome(), updatedNutricionista.getAnosDeExperiencia(), updatedNutricionista.getCertificacoes()));
    }

    @PatchMapping("/{id}/certifications")
    public ResponseEntity<NutricionistaResponseDTO> addCertification(@PathVariable Long id, @RequestBody String certification) {
        Nutricionista updatedNutricionista = nutricionistaService.addCertification(id, certification);
        return ResponseEntity.ok(new NutricionistaResponseDTO(updatedNutricionista.getId(), updatedNutricionista.getCrn(), updatedNutricionista.getEspecialidade(), updatedNutricionista.getNome(), updatedNutricionista.getAnosDeExperiencia(), updatedNutricionista.getCertificacoes()));
    }
}