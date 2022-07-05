package br.com.cliente.crud.controller;

import br.com.cliente.crud.model.Usuario;
import br.com.cliente.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
