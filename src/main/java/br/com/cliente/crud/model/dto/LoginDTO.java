package br.com.cliente.crud.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank
    private String cpf;

    @NotBlank
    private String senha;
}
