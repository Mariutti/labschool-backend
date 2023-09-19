package com.example.labschool.dtos;

import java.util.Date;

import com.example.labschool.models.PedagogoModel;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PedagogoDto (
    
    @NotEmpty(message = "O campo nome é obrigatório.")
    String nome, 

    @NotBlank(message = "O campo telefone é obrigatório.")
    @Size(min =16, max = 16)
    String telefone, 

    @NotNull(message = "O campo data é obrigatório.")
    @Temporal(TemporalType.DATE)
    Date dataNascimento, 

    @NotBlank(message = "O campo CPF é obrigatório.")
    @Size(min = 14, max = 14)
    String cpf, 

    @NotBlank(message = "O campo email é obrigatório.")
    String email, 

    @NotBlank(message = "O campo senha é obrigatório.")
    String senha) {
    

        public PedagogoDto(PedagogoModel pedagogoModel) {
            this(
                pedagogoModel.getNome(),
                pedagogoModel.getTelefone(),
                pedagogoModel.getDataNascimento(),
                pedagogoModel.getCpf(),
                pedagogoModel.getEmail(),
                pedagogoModel.getSenha()
                );
        }
}
