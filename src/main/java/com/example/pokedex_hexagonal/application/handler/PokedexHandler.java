package com.example.pokedex_hexagonal.application.handler;

import com.example.pokedex_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_hexagonal.application.dto.PokedexResponse;
import com.example.pokedex_hexagonal.application.mapper.PokedexRequestMapper;
import com.example.pokedex_hexagonal.application.mapper.PokedexResponseMapper;
import com.example.pokedex_hexagonal.domain.api.IPokemonServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokedexHandler implements IPokedexHandler {

    private final IPokemonServicePort pokemonServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;

    @Override
    public void savePokemonInPokedex(PokedexRequest pokedexRequest) {
        pokemonServicePort.savePokemon(pokedexRequestMapper.toPokemon(pokedexRequest));
    }

    @Override
    public List<PokedexResponse> getAllPokemonFromPokedex() {
        return pokedexResponseMapper.toResponseList(pokemonServicePort.getAllPokemon());
    }

    @Override
    public PokedexResponse getPokemonFromPokedex(Long pokemonNumber) {
        return pokedexResponseMapper.toResponse(pokemonServicePort.getPokemon(pokemonNumber));
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequest pokedexRequest) {
        pokemonServicePort.getPokemon(pokedexRequest.getNumber());
        pokemonServicePort.updatePokemon(pokedexRequestMapper.toPokemon(pokedexRequest));
    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {
        pokemonServicePort.getPokemon(pokemonNumber);
        pokemonServicePort.deletePokemon(pokemonNumber);
    }
}