package com.example.pokedex_hexagonal.infrastructure.exceptionhandler;

import com.example.pokedex_hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.pokedex_hexagonal.infrastructure.exception.PokemonAlreadyExistsException;
import com.example.pokedex_hexagonal.infrastructure.exception.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(PokemonAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handlePokemonAlreadyExistsException(
            PokemonAlreadyExistsException pokemonAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.POKEMON_ALREADY_EXISTS.getMessage()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePokemonNotFoundException(
            PokemonNotFoundException pokemonNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.POKEMON_NOT_FOUND.getMessage()));
    }
}