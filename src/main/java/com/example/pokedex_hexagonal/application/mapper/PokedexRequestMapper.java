package com.example.pokedex_hexagonal.application.mapper;

import com.example.pokedex_hexagonal.application.dto.PokedexRequest;
import com.example.pokedex_hexagonal.domain.model.Pokemon;
import com.example.pokedex_hexagonal.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PokedexRequestMapper {

    Pokemon toPokemon(PokedexRequest pokedexRequest);

    @Mapping(source = "pokedexRequest.types.firstType", target = "firstType")
    @Mapping(source = "pokedexRequest.types.secondType", target = "secondType")
    Type toType(PokedexRequest pokedexRequest);
}