package com.senai.S7M2.repository;

import com.senai.S7M2.model.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
    Optional<PerfilEntity> findByNomePerfil(String nomePerfil);
}
