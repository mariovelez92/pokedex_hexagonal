package com.example.pokedex_hexagonal.domain.spi;

import com.example.pokedex_hexagonal.domain.model.Photo;

import java.util.List;

public interface IPhotoPersistencePort {
    Photo savePhoto(Photo photo);

    List<Photo> getAllPhotos();

    Photo getPhoto(String photoId);

    void updatePhoto(Photo photo);

    void deletePhoto(String photoId);
}