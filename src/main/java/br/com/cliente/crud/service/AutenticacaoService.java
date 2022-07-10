package br.com.cliente.crud.service;

import br.com.cliente.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AutenticacaoService {

    @Autowired
    UsuarioRepository usuarioRepository;
}
