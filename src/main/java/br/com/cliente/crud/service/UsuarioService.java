package br.com.cliente.crud.service;

import br.com.cliente.crud.model.Endereco;
import br.com.cliente.crud.model.Usuario;
import br.com.cliente.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.getOne(id);
    }

    @Transactional
    public Usuario atualizar(Usuario usuario) {
        Usuario usuarioEdit = this.getUsuarioById(usuario.getIdUsuario());

        Endereco enderecoEdit = usuario.getEndereco();
        enderecoEdit.setId(usuario.getEndereco().getId());

        usuarioEdit.setNome(usuario.getNome());
        usuarioEdit.setEndereco(enderecoEdit);

        return usuarioRepository.save(usuarioEdit);
    }
}
