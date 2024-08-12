package com.senai.S7M2.controller;

import com.senai.S7M2.dto.PerfilRequest;
import com.senai.S7M2.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;


    @PostMapping("/perfil")
    public ResponseEntity<String> cadastraPerfil(
            @RequestBody PerfilRequest perfilRequest
    ){
        perfilService.cadastraPerfil(perfilRequest);

        return new ResponseEntity<>("Perfil Criado",HttpStatus.CREATED);
    }
}