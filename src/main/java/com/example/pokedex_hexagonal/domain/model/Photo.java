package com.example.pokedex_hexagonal.domain.model;

public class Photo {
    private String id;
    private byte[] photo;

    public Photo(String id, byte[] photo) {
        this.id = id;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}