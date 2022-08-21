package com.example.pokedex_hexagonal.application.handler;

import com.example.pokedex_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_hexagonal.application.dto.PokedexResponse;

import java.util.List;

public interface IPokedexHandler {

    void savePokemonInPokedex(PokedexRequest pokedexRequest);

    List<PokedexResponse> getAllPokemonFromPokedex();

    PokedexResponse getPokemonFromPokedex(Long pokemonNumber);

    void updatePokemonInPokedex(PokedexRequest pokedexRequest);

    void deletePokemonFromPokedex(Long pokemonNumber);
}