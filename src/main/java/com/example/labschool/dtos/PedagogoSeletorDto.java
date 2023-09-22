package com.example.labschool.dtos;

import com.example.labschool.models.PedagogoModel;

import java.util.UUID;

public record PedagogoSeletorDto(
        UUID id,
        String nome
){
}
