package com.example.pokedex_hexagonal.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexRequest {
    private Long number;
    private String name;
}