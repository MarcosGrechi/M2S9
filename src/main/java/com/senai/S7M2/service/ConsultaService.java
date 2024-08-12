package com.senai.S7M2.service;

import com.senai.S7M2.model.Consulta;
import com.senai.S7M2.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta updateConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public Consulta getConsultaById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public List<Object[]> getAllConsultasInfo() {
        return consultaRepository.findAll().stream()
                .map(consulta -> new Object[]{
                        consulta.getDataDaConsulta(),
                        consulta.getNutricionista().getNome(),
                        consulta.getPaciente().getNome()
                })
                .collect(Collectors.toList());
    }
}
