package com.senai.S7M2.controller;

import com.senai.S7M2.dto.LoginRequest;
import com.senai.S7M2.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("cadastro")
    public ResponseEntity<?> cadastraUsuario(
            @RequestBody LoginRequest cadastroRequest
            ) {
        usuarioService.cadastraUsuario(cadastroRequest);

        return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
    }
}
