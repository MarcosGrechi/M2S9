package com.senai.S7M2.service;

import com.senai.S7M2.model.Nutricionista;
import com.senai.S7M2.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutricionistaService {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public Nutricionista createNutricionista(Nutricionista nutricionista) {
        if(nutricionistaRepository.findByNome(nutricionista.getNome()).isPresent()) {
            throw new RuntimeException("Nutricionista com o mesmo nome já existe");
        }
        return nutricionistaRepository.save(nutricionista);
    }

    public Nutricionista updateNutricionista(Nutricionista nutricionista) {
        return nutricionistaRepository.save(nutricionista);
    }

    public void deleteNutricionista(Long id) {
        nutricionistaRepository.deleteById(id);
    }

    public List<Nutricionista> getAllNutricionistas() {
        return nutricionistaRepository.findAll();
    }

    public Nutricionista getNutricionistaById(Long id) {
        return nutricionistaRepository.findById(id).orElse(null);
    }

    public Nutricionista addYearToExperience(Long id) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
        nutricionista.setEspecialidade(String.valueOf(nutricionista.getAnosDeExperiencia() + 1));
        return nutricionistaRepository.save(nutricionista);
    }

    public Nutricionista addCertification(Long id, String certification) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
        nutricionista.getCertificacoes().add(certification);
        return nutricionistaRepository.save(nutricionista);
    }

    public NutricionistaService(NutricionistaRepository nutricionistaRepository) {
        this.nutricionistaRepository = nutricionistaRepository;
    }
}