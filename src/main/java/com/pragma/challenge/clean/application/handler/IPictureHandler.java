package com.pragma.challenge.clean.application.handler;

import com.pragma.challenge.clean.application.dto.PictureRequest;
import com.pragma.challenge.clean.application.dto.PictureResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface IPictureHandler {

    void savePicture(PictureRequest pictureRequest);

    List<PictureResponse> getAllPictures();

    PictureResponse getPictureByIdentificationNumber(String in);

    InputStream getImageResource(String in);

    void updatePictureByIdentificationNumber(String in, MultipartFile imageFile);

    void deletePictureByIdentificationNumber(String in);

}
