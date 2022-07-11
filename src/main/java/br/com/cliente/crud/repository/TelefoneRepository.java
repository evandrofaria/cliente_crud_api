package br.com.cliente.crud.repository;

import br.com.cliente.crud.model.Telefone;
import br.com.cliente.crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    List<Telefone> findTelefoneByUsuario(Usuario usuario);
}
