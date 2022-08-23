package com.example.pokedex_hexagonal.application.mapper;

import com.example.pokedex_hexagonal.application.dto.TypeDto;
import com.example.pokedex_hexagonal.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TypeDtoMapper {

    TypeDto toDto(Type type);
}