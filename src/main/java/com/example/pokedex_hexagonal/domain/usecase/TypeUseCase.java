package com.example.pokedex_hexagonal.domain.usecase;

import com.example.pokedex_hexagonal.domain.api.ITypeServicePort;
import com.example.pokedex_hexagonal.domain.model.Type;
import com.example.pokedex_hexagonal.domain.spi.ITypePersistencePort;

import java.util.List;

public class TypeUseCase implements ITypeServicePort {

    private final ITypePersistencePort typePersistencePort;

    public TypeUseCase(ITypePersistencePort typePersistencePort) {
        this.typePersistencePort = typePersistencePort;
    }

    @Override
    public Type saveType(Type type) {
        return typePersistencePort.saveType(type);
    }

    @Override
    public List<Type> getAllTypes() {
        return typePersistencePort.getAllTypes();
    }

    @Override
    public Type getType(Long typeId) {
        return typePersistencePort.getType(typeId);
    }

    @Override
    public void updateType(Type type) {
        typePersistencePort.updateType(type);
    }

    @Override
    public void deleteType(Long typeId) {
        typePersistencePort.deleteType(typeId);
    }
}