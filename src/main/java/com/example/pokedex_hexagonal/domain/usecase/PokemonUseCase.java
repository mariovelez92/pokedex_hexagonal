package com.example.pokedex_hexagonal.domain.usecase;

import com.example.pokedex_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_hexagonal.domain.exception.NoDataFoundException;
import com.example.pokedex_hexagonal.domain.exception.PokemonAlreadyExistsException;
import com.example.pokedex_hexagonal.domain.exception.PokemonNotFoundException;
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
        if (pokemonPersistencePort.getPokemon(pokemon.getNumber()).isPresent()) {
            throw new PokemonAlreadyExistsException();
        }
        pokemonPersistencePort.savePokemon(pokemon);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = pokemonPersistencePort.getAllPokemon();
        if (pokemonList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return pokemonList;
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonPersistencePort.getPokemon(pokemonNumber).orElseThrow(PokemonNotFoundException::new);
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