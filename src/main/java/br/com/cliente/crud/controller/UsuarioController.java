package br.com.cliente.crud.controller;

import br.com.cliente.crud.model.Endereco;
import br.com.cliente.crud.model.Usuario;
import br.com.cliente.crud.repository.EmailRepository;
import br.com.cliente.crud.repository.UsuarioRepository;
import br.com.cliente.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping(path = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getUsuario(@PathVariable Long id) {

        return usuarioService.getUsuarioById(id);
    }

    @GetMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listarTodos() {

        return usuarioRepository.obterTodos();
    }

    @PutMapping
    @RequestMapping("/usuarios/edit/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id,
                                    @RequestBody Usuario usuario) {

        usuario.setIdUsuario(id);
        Endereco endereco = usuario.getEndereco();
        endereco.setId(usuario.getEndereco().getId());

        return usuarioService.atualizar(usuario);
    }
}
