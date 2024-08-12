package com.senai.S7M2.service;

import com.senai.S7M2.infra.UsuarioUserDetails;
import com.senai.S7M2.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioUserDetails usuario = usuarioRepository.findByUsername(username)
                .map(usuarioEntity -> new UsuarioUserDetails(usuarioEntity))
                .orElseThrow(()-> new UsernameNotFoundException("Nome de usuario não econtrado : "+username));

        return usuario;
    }

}
