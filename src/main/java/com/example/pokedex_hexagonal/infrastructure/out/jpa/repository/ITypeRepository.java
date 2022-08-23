package com.example.pokedex_hexagonal.infrastructure.out.jpa.repository;

import com.example.pokedex_hexagonal.infrastructure.out.jpa.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<TypeEntity, Long> {}