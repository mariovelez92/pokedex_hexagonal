package com.example.pokedex_hexagonal.infrastructure.out.jpa.adapter;

import com.example.pokedex_hexagonal.domain.model.Pokemon;
import com.example.pokedex_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.pokedex_hexagonal.infrastructure.exception.PokemonAlreadyExistsException;
import com.example.pokedex_hexagonal.infrastructure.exception.PokemonNotFoundException;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.entity.PokemonEntity;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper.PokemonEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PokemonJpaAdapter implements IPokemonPersistencePort {

    private final IPokemonRepository pokemonRepository;

    private final PokemonEntityMapper pokemonEntityMapper;

    @Override
    public void savePokemon(Pokemon pokemon) {
        if (pokemonRepository.findByNumber(pokemon.getNumber()).isPresent()) {
            throw new PokemonAlreadyExistsException();
        }
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        List<PokemonEntity> pokemonEntityList = pokemonRepository.findAll();
        if (pokemonEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return pokemonEntityMapper.toPokemonList(pokemonEntityList);
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonEntityMapper.toPokemon(pokemonRepository.findByNumber(pokemonNumber)
                .orElseThrow(PokemonNotFoundException::new));
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