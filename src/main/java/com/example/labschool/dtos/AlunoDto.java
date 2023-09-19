package com.example.labschool.dtos;

import com.example.labschool.models.AlunoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

public record AlunoDto(

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

        @NotNull(message = "O campo nota é obrigatório.")
        @Range(min = 0, max = 10)
        Integer nota
        ) {
        public AlunoDto(AlunoModel alunoModel){
                this(
                        alunoModel.getNome(),
                        alunoModel.getTelefone(),
                        alunoModel.getDataNascimento(),
                        alunoModel.getCpf(),
                        alunoModel.getNota()
                        );
        }
}
