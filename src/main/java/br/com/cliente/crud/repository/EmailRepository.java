package br.com.cliente.crud.repository;

import br.com.cliente.crud.model.Email;
import br.com.cliente.crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findEmailsByUsuario(Usuario usuario);
}
