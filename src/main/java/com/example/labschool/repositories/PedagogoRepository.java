package com.example.labschool.repositories;

import java.util.List;
import java.util.UUID;

import com.example.labschool.dtos.PedagogoSeletorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.labschool.models.PedagogoModel;

@Repository
public interface PedagogoRepository extends JpaRepository<PedagogoModel, UUID>{

    @Query(value = "SELECT new com.example.labschool.dtos.PedagogoseletorDto(pd.id, pd.nome)"
    + "FROM com.example.labschool.models.PedagogoModel pd")
    List<PedagogoSeletorDto> findAllByIdName();
}