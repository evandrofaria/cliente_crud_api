package br.com.cliente.crud.controller;

import br.com.cliente.crud.model.Email;
import br.com.cliente.crud.model.Telefone;
import br.com.cliente.crud.model.Usuario;
import br.com.cliente.crud.repository.EmailRepository;
import br.com.cliente.crud.repository.TelefoneRepository;
import br.com.cliente.crud.repository.UsuarioRepository;
import br.com.cliente.crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listar() {

        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getUsuario(@PathVariable Long id) {

        return usuarioRepository.getOne(id);
    }

    @GetMapping(path = "/{id}/emails", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Email> getEmails(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getOne(id);

        return emailRepository.findEmailsByUsuario(usuario);
    }

    @GetMapping(path = "/{id}/telefones", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Telefone> getTelefones(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getOne(id);

        return telefoneRepository.findTelefoneByUsuario(usuario);
    }

    @PutMapping("/{id}/dados-basicos/editar")
    public Usuario atualizarUsuario(@PathVariable Long id,
                                    @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);

        return usuarioService.atualizarDadosBasicos(usuario);
    }

    @PutMapping("/{id}/emails/editar")
    public Email atualizarEmails(@PathVariable Long id,
                                 @Validated(Email.Existing.class)
                                 @RequestBody Email emailInsert) {

        Email atualizar = this.emailRepository.getOne(emailInsert.getId());
        atualizar.setId(emailInsert.getId());
        atualizar.setIdUsuario(id);

        if (emailInsert.getEmail() != null) {
            atualizar.setEmail(emailInsert.getEmail());
        }

        return emailRepository.save(atualizar);
    }

    @PutMapping("/{id}/telefones/editar")
    public Telefone atualizarTelefones(@PathVariable Long id,
                                       @Validated(Telefone.Existing.class)
                                       @RequestBody Telefone telefoneInsert) {

        Telefone atualizar = this.telefoneRepository.getOne(telefoneInsert.getId());
        atualizar.setId(telefoneInsert.getId());
        atualizar.setIdUsuario(id);

        if (telefoneInsert.getTelefone() != null) {
            atualizar.setTelefone(telefoneInsert.getTelefone());
        }

        if (telefoneInsert.getTipoTelefone() != null) {
            atualizar.setTipoTelefone(telefoneInsert.getTipoTelefone());
        }

        return telefoneRepository.save(atualizar);
    }
}
