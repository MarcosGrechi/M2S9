package com.senai.S7M2.repository;

import com.senai.S7M2.model.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    Optional<Nutricionista> findByNome(String nome);
}