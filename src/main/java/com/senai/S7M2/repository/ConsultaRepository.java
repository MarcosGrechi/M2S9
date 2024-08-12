package com.senai.S7M2.repository;

import com.senai.S7M2.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}