package com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper;

import com.example.pokedex_hexagonal.domain.model.Type;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.entity.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TypeEntityMapper {

    TypeEntity toEntity(Type type);

    Type toType(TypeEntity typeEntity);

    List<Type> toTypeList(List<TypeEntity> typeEntityList);
}