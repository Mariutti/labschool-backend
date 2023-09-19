package com.example.labschool.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="TB_PEDAGOGO")
@Data
public class PedagogoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private String telefone;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String cpf;

    private String email;

    private String senha;

    @OneToMany(mappedBy = "pedagogo")
    private List<AcompanhamentoPedagogicoModel> acompanhamentoPedagogicoModel;

    }