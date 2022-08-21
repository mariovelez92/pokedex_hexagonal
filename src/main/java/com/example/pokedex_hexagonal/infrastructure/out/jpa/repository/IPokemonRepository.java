package com.example.pokedex_hexagonal.infrastructure.out.jpa.repository;

import com.example.pokedex_hexagonal.infrastructure.out.jpa.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPokemonRepository extends JpaRepository<PokemonEntity, Long> {

    Optional<PokemonEntity> findByNumber(Long pokemonNumber);

    void deleteByNumber(Long pokemonNumber);
}