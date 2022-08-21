package com.example.pokedex_hexagonal.infrastructure.out.jpa.adapter;

import com.example.pokedex_hexagonal.domain.model.Pokemon;
import com.example.pokedex_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper.PokemonEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PokemonJpaAdapter implements IPokemonPersistencePort {

    private final IPokemonRepository pokemonRepository;

    private final PokemonEntityMapper pokemonEntityMapper;

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonEntityMapper.toPokemonList(pokemonRepository.findAll());
    }

    @Override
    public Optional<Pokemon> getPokemon(Long pokemonNumber) {
        return Optional.ofNullable(pokemonEntityMapper.toPokemon(pokemonRepository.findByNumber(pokemonNumber)));
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonEntityMapper.toEntity(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonRepository.deleteByNumber(pokemonNumber);
    }
}