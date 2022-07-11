package br.com.cliente.crud.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_telefone")
@SequenceGenerator(name = "tb_telefone_id_telefone_seq", sequenceName = "tb_telefone_id_telefone_seq", allocationSize = 1)
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_telefone_id_telefone_seq")
    @Column(name = "id_telefone", updatable = false, nullable = false)
    Long id;

    @Column(name = "no_telefone")
    String telefone;

    @Column(name = "ds_tipo")
    String tipoTelefone;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Telefone() {
    }

    public interface Existing {
    }

    public interface New {
    }

    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdUsuario(Long idUsuario) {
        usuario.setIdUsuario(idUsuario);
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public void addTelefones(String telefone, String tipoTelefone, Usuario usuario) {
        this.setTelefone(telefone);
        this.setTipoTelefone(tipoTelefone);
        setUsuario(usuario);
    }
}
