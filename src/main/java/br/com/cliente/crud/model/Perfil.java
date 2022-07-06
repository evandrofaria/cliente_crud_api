package br.com.cliente.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tb_perfil")
public class Perfil {

    @Id
    @Column(name="id_perfil")
    private Long id;

    @Column(name="ds_role")
    String perfil;

    public Long getId() {
        return id;
    }

    public String getRole() { return perfil; }
}
