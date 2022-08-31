package com.example.pokedex_hexagonal.infrastructure.out.mongodb.repository;

import com.example.pokedex_hexagonal.infrastructure.out.mongodb.entity.PhotoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPhotoRepository extends MongoRepository<PhotoEntity, String> {}