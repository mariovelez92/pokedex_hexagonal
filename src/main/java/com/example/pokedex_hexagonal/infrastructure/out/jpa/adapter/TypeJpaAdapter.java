package com.example.pokedex_hexagonal.infrastructure.out.jpa.adapter;

import com.example.pokedex_hexagonal.domain.model.Type;
import com.example.pokedex_hexagonal.domain.spi.ITypePersistencePort;
import com.example.pokedex_hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.pokedex_hexagonal.infrastructure.exception.TypeNotFoundException;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.entity.TypeEntity;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper.TypeEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.repository.ITypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TypeJpaAdapter implements ITypePersistencePort {

    private final ITypeRepository typeRepository;
    private final TypeEntityMapper typeEntityMapper;

    @Override
    public Type saveType(Type type) {
        return typeEntityMapper.toType(typeRepository.save(typeEntityMapper.toEntity(type)));
    }

    @Override
    public List<Type> getAllTypes() {
        List<TypeEntity> typeEntityList = typeRepository.findAll();
        if (typeEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return typeEntityMapper.toTypeList(typeEntityList);
    }

    @Override
    public Type getType(Long typeId) {
        return typeEntityMapper.toType(typeRepository.findById(typeId).orElseThrow(TypeNotFoundException::new));
    }

    @Override
    public void updateType(Type type) {
        typeRepository.save(typeEntityMapper.toEntity(type));
    }

    @Override
    public void deleteType(Long typeId) {
        typeRepository.deleteById(typeId);
    }
}
