package com.example.labschool.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labschool.models.PedagogoModel;

@Repository
public interface PedagogoRepository extends JpaRepository<PedagogoModel, UUID>{}