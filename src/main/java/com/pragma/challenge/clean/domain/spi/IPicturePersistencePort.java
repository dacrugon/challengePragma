package com.pragma.challenge.clean.domain.spi;

import com.pragma.challenge.clean.domain.model.Picture;

import java.util.List;

public interface IPicturePersistencePort {

    void savePicture(Picture picture);

    List<Picture> getAllPictures();

    Picture getPictureByIdentificationNumber(String id);

    void updatePicture(Picture picture);

    void deletePictureByIdentificationNumber(String id);

}
