package com.example.pokedex_hexagonal.infrastructure.out.mongodb.adapter;

import com.example.pokedex_hexagonal.domain.model.Photo;
import com.example.pokedex_hexagonal.domain.spi.IPhotoPersistencePort;
import com.example.pokedex_hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.pokedex_hexagonal.infrastructure.exception.PhotoNotFoundException;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.entity.PhotoEntity;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.mapper.PhotoEntityMapper;
import com.example.pokedex_hexagonal.infrastructure.out.mongodb.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhotoMongodbAdapter implements IPhotoPersistencePort {

    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Override
    public Photo savePhoto(Photo photo) {
        return photoEntityMapper.toPhoto(photoRepository.save(photoEntityMapper.toEntity(photo)));
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<PhotoEntity> photoEntityList = photoRepository.findAll();
        if (photoEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return photoEntityMapper.toPhotoList(photoEntityList);
    }

    @Override
    public Photo getPhoto(String photoId) {
        return photoEntityMapper.toPhoto(photoRepository.findById(photoId).orElseThrow(PhotoNotFoundException::new));
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoRepository.save(photoEntityMapper.toEntity(photo));
    }

    @Override
    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }
}