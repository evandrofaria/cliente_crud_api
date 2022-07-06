package br.com.cliente.crud.model;

import br.com.cliente.crud.util.Util;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
@SequenceGenerator(name = "tb_usuario_id_usuario_seq", sequenceName = "tb_usuario_id_usuario_seq", allocationSize = 1)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_id_usuario_seq")
    @Column(name = "id_usuario", updatable = false, nullable = false)
    Long idUsuario;

    @Column(name = "no_usuario")
    String nome;

    @Column(name = "ds_senha")
    String senha;

    @Column(name = "nu_cpf")
    String cpf;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    private List<Email> email = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Telefone> telefones = new ArrayList<>();

    public String getCpfMasked() {
        return Util.getCpfWithMask(this.cpf);
    }
}
