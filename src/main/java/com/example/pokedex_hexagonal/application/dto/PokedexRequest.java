package com.example.pokedex_hexagonal.application.dto;

import com.example.pokedex_hexagonal.domain.model.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexRequest {
    private Long number;
    private String name;
    private Type types;
    private String photo;
}