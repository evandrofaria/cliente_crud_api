package br.com.cliente.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Endereco endereco;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Email> emails = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Telefone> telefones = new ArrayList<>();

}
