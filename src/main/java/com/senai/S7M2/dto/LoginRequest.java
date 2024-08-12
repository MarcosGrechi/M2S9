package com.senai.S7M2.dto;

public record LoginRequest(
        String username,
        String password,
        String nomePerfil

) {
}
