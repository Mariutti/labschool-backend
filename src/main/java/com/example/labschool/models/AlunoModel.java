package com.example.labschool.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ALUNO")
@Data
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String telefone;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String cpf;

    private Integer nota;

    @OneToMany(mappedBy = "aluno")
    private List<AcompanhamentoPedagogicoModel> acompanhamentoPedagogicoModel;

}