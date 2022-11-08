package com.pragma.challenge.clean.domain.spi;

import com.pragma.challenge.clean.domain.model.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface IPicturePersistencePort {

    void savePicture(Picture picture);

    List<Picture> getAllPictures();

    Picture getPictureByIdentificationNumber(String in);


    void updatePicture(Picture picture);


    void deletePictureByIdentificationNumber(String in);
}
