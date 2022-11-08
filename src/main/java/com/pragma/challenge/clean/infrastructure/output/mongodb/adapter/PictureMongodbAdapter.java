package com.pragma.challenge.clean.infrastructure.output.mongodb.adapter;

import com.pragma.challenge.clean.domain.model.Picture;
import com.pragma.challenge.clean.domain.spi.IPicturePersistencePort;
import com.pragma.challenge.clean.infrastructure.output.mongodb.mapper.IPictureEntityMapper;
import com.pragma.challenge.clean.infrastructure.output.mongodb.repository.IPictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RequiredArgsConstructor
public class PictureMongodbAdapter implements IPicturePersistencePort {

    private final IPictureRepository pictureRepository;
    private final IPictureEntityMapper pictureEntityMapper;
    @Override
    public void savePicture(Picture picture) {
        pictureRepository.save(pictureEntityMapper.toEntity(picture));
    }

    @Override
    public List<Picture> getAllPictures() {
        return pictureEntityMapper.toPictureList(pictureRepository.findAll());
    }

    @Override
    public Picture getPictureByIdentificationNumber(String in) {
        return pictureEntityMapper.toPicture(pictureRepository.findByIdentificationNumber(in));
    }

    @Override
    public void updatePicture(Picture picture) {
        pictureRepository.save(pictureEntityMapper.toEntity(picture));
    }
    @Override
    public void deletePictureByIdentificationNumber(String in) {
        pictureRepository.deleteByIdentificationNumber(in);
    }

}
