package com.example.labschool.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_ACOMPANHAMENTO")
@Data
public class AcompanhamentoPedagogicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoModel aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private PedagogoModel pedagogo;


    @Temporal(TemporalType.DATE)
    private Date dataAcompanhamento;

    private String titulo;

    private String descricao;

    private boolean finalizado=false;
}
