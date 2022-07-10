package br.com.cliente.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_email")
@SequenceGenerator(name = "tb_email_id_email_seq", sequenceName = "tb_email_id_email_seq", allocationSize = 1)
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_email_id_email_seq")
    @Column(name = "id_email", updatable = false, nullable = false)
    Long id;

    @Column(name = "ds_email")
    String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
