package com.example.pokedex_hexagonal.infrastructure.configuration;

import com.example.pokedex_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_hexagonal.domain.api.ITypeServicePort;
import com.example.pokedex_hexagonal.domain.spi.IPhotoPersistencePort;
import com.example.pokedex_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_hexagonal.domain.spi.ITypePersistencePort;
import com.example.pokedex_hexagonal.domain.usecase.PhotoUseCase;
import com.example.pokedex_hexagonal.domain.usecase.PokemonUseCase;
import com.example.pokedex_hexagonal.domain.usecase.TypeUseCase;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.adapter.PokemonJpaAdapter;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.adapter.TypeJpaAdapter;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper.PokemonEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper.TypeEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.repository.IPokemonRepository;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.repository.ITypeRepository;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.adapter.PhotoMongodbAdapter;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.mapper.PhotoEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPokemonRepository pokemonRepository;
    private final PokemonEntityMapper pokemonEntityMapper;
    private final ITypeRepository typeRepository;
    private final TypeEntityMapper typeEntityMapper;
    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Bean
    public IPokemonPersistencePort pokemonPersistencePort() {
        return new PokemonJpaAdapter(pokemonRepository, pokemonEntityMapper);
    }

    @Bean
    public IPokemonServicePort pokemonServicePort() {
        return new PokemonUseCase(pokemonPersistencePort());
    }

    @Bean
    public ITypePersistencePort typePersistencePort() {
        return new TypeJpaAdapter(typeRepository, typeEntityMapper);
    }

    @Bean
    public ITypeServicePort typeServicePort() {
        return new TypeUseCase(typePersistencePort());
    }

    @Bean
    public IPhotoPersistencePort photoPersistencePort() {
        return new PhotoMongodbAdapter(photoRepository, photoEntityMapper);
    }

    @Bean
    public IPhotoServicePort photoServicePort() {
        return new PhotoUseCase(photoPersistencePort());
    }
}