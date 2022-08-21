package com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper;

import com.example.pokedex_hexagonal.domain.model.Pokemon;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.entity.PokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PokemonEntityMapper {

    PokemonEntity toEntity(Pokemon pokemon);

    Pokemon toPokemon(Optional<PokemonEntity> pokemonEntity);

    List<Pokemon> toPokemonList(List<PokemonEntity> pokemonEntityList);
}