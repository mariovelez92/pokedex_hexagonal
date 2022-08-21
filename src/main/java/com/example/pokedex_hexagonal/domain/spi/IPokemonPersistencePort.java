package com.example.pokedex_hexagonal.domain.spi;

import com.example.pokedex_hexagonal.domain.model.Pokemon;

import java.util.List;
import java.util.Optional;

public interface IPokemonPersistencePort {

    void savePokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    Optional<Pokemon> getPokemon(Long pokemonNumber);

    void updatePokemon(Pokemon pokemon);

    void deletePokemon(Long pokemonNumber);
}