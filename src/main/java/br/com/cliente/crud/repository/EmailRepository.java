package br.com.cliente.crud.repository;

import br.com.cliente.crud.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> {

    @Query("SELECT email FROM Email email WHERE email.usuario = :idUsuario")
    List<Email> obterEmailsUsuario(Long idUsuario);
}
