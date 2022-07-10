package br.com.cliente.crud.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name = "tb_endereco_id_endereco_seq", sequenceName = "tb_endereco_id_endereco_seq", allocationSize = 1)
public class Endereco {

    @Id
    @Column(name = "id_endereco")
    private Long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "nu_cep")
    String cep;

    @Column(name = "ds_logradouro")
    String logradouro;

    @Column(name = "ds_bairro")
    String bairro;

    @Column(name = "ds_cidade")
    String cidade;

    @Column(name = "ds_uf")
    String uf;

    @Column(name = "ds_complemento")
    String complemento;
}
