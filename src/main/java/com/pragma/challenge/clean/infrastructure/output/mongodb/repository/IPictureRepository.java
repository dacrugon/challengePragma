package com.pragma.challenge.clean.infrastructure.output.mongodb.repository;

import com.pragma.challenge.clean.infrastructure.output.mongodb.entity.PictureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPictureRepository extends MongoRepository<PictureEntity,String> {

    PictureEntity findByIdentificationNumber(String in);

    void deleteByIdentificationNumber(String in);
}
