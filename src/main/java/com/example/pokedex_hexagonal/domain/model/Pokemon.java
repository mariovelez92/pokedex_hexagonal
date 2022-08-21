package com.example.pokedex_hexagonal.domain.model;

public class Pokemon {

    private Long number;
    private String name;

    public Pokemon(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}