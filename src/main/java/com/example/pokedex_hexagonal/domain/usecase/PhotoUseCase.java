package com.example.pokedex_hexagonal.domain.usecase;

import com.example.pokedex_hexagonal.domain.api.IPhotoServicePort;
import com.example.pokedex_hexagonal.domain.model.Photo;
import com.example.pokedex_hexagonal.domain.spi.IPhotoPersistencePort;

import java.util.List;

public class PhotoUseCase implements IPhotoServicePort {

    private final IPhotoPersistencePort photoPersistencePort;

    public PhotoUseCase(IPhotoPersistencePort photoPersistencePort) {
        this.photoPersistencePort = photoPersistencePort;
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoPersistencePort.savePhoto(photo);
    }

    @Override
    public List<Photo> getAllPhotos() {
        return photoPersistencePort.getAllPhotos();
    }

    @Override
    public Photo getPhoto(String photoId) {
        return photoPersistencePort.getPhoto(photoId);
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoPersistencePort.updatePhoto(photo);
    }

    @Override
    public void deletePhoto(String photoId) {
        photoPersistencePort.deletePhoto(photoId);
    }
}