package com.example.pokedex_hexagonal.infrastructure.configuration;

import com.example.pokedex_hexagonal.domain.api.IPokemonServicePort;
import com.example.pokedex_hexagonal.domain.spi.IPokemonPersistencePort;
import com.example.pokedex_hexagonal.domain.usecase.PokemonUseCase;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.adapter.PokemonJpaAdapter;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.mapper.PokemonEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.jpa.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPokemonRepository pokemonRepository;
    private final PokemonEntityMapper pokemonEntityMapper;

    @Bean
    public IPokemonPersistencePort pokemonPersistencePort() {
        return new PokemonJpaAdapter(pokemonRepository, pokemonEntityMapper);
    }

    @Bean
    public IPokemonServicePort pokemonServicePort() {
        return new PokemonUseCase(pokemonPersistencePort());
    }
}