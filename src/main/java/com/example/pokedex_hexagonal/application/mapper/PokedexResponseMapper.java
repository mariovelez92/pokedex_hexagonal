package com.example.pokedex_hexagonal.application.mapper;

import com.example.pokedex_hexagonal.application.dto.PokedexResponse;
import com.example.pokedex_hexagonal.application.dto.TypeDto;
import com.example.pokedex_hexagonal.domain.model.Pokemon;
import com.example.pokedex_hexagonal.domain.model.Type;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {TypeDtoMapper.class})
public interface PokedexResponseMapper {

    TypeDtoMapper INSTANCE = Mappers.getMapper(TypeDtoMapper.class);

    @Mapping(target = "types.firstType", source = "typeDto.firstType")
    @Mapping(target = "types.secondType", source = "typeDto.secondType")
    PokedexResponse toResponse(Pokemon pokemon, TypeDto typeDto);

    default List<PokedexResponse> toResponseList(List<Pokemon> pokemonList, List<Type> typeList) {
        return pokemonList.stream()
                .map(pokemon -> {
                    PokedexResponse pokedexResponse = new PokedexResponse();
                    pokedexResponse.setNumber(pokemon.getNumber());
                    pokedexResponse.setName(pokemon.getName());
                    pokedexResponse.setTypes(INSTANCE.toDto(typeList.stream().filter(type -> type.getId() == pokemon.getTypeId()).findFirst().orElse(null)));
                    return pokedexResponse;
                }).toList();
    }
}