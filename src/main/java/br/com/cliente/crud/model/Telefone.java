package br.com.cliente.crud.model;


import br.com.cliente.crud.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_telefone")
@SequenceGenerator(name = "tb_email_id_telefone_seq", sequenceName = "tb_email_id_telefone_seq", allocationSize = 1)
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_email_id_telefone_seq")
    @Column(name = "id_telefone")
    Long id;

    @Column(name = "no_telefone")
    String telefone;

    @Column(name = "ds_tipo")
    String tipoTelefone;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public String getTelefone() {
        return Util.getTelWithMask(this.telefone);
    }
}
