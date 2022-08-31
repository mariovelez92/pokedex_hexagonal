package com.example.pokedex_hexagonal.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexResponse {
    private Long number;
    private String name;
    private TypeDto types;
    private String photo;
}