package br.com.cliente.crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_email")
@SequenceGenerator(name = "tb_email_id_email_seq", sequenceName = "tb_email_id_email_seq", allocationSize = 1)
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_email_id_email_seq")
    @Column(name = "id_email", updatable = false, nullable = false)
    Long id;

    @Column(name = "ds_email")
    String email;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public interface Existing {
    }

    public interface New {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setIdUsuario(Long idUsuario) {
        usuario.setIdUsuario(idUsuario);
    }

    public void setEmail(String email, Usuario usuario) {
        this.setEmail(email);
        setUsuario(usuario);
    }
}
