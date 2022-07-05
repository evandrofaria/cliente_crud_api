package br.com.cliente.crud.model;


import br.com.cliente.crud.util.MaskUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(name = "tb_endereco_id_endereco_seq", sequenceName = "tb_endereco_id_endereco_seq", allocationSize = 1)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_endereco_id_endereco_seq")
    @Column(name = "id_endereco", nullable = false, columnDefinition = "NUMBER(10)")
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    @JoinColumn(name = "id_usuario", nullable = false)
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

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return MaskUtil.getCepWithMask(this.cep);
    }
}
