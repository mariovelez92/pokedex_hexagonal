package com.example.pokedex_hexagonal.domain.usecase;

import com.example.pokedex_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_hexagonal.domain.model.Pokemon;
import com.example.pokedex_hexagonal.domain.spi.IPokemonPersistencePort;

import java.util.List;

public class PokemonUseCase implements IPokemonServicePort {

    private final IPokemonPersistencePort pokemonPersistencePort;

    public PokemonUseCase(IPokemonPersistencePort pokemonPersistencePort) {
        this.pokemonPersistencePort = pokemonPersistencePort;
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonPersistencePort.savePokemon(pokemon);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonPersistencePort.getAllPokemon();
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonPersistencePort.getPokemon(pokemonNumber);
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonPersistencePort.updatePokemon(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonPersistencePort.deletePokemon(pokemonNumber);
    }
}