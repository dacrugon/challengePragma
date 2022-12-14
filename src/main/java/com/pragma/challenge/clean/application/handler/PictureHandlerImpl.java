package com.pragma.challenge.clean.application.handler;

import com.pragma.challenge.clean.application.dto.PictureRequest;
import com.pragma.challenge.clean.application.dto.PictureResponse;
import com.pragma.challenge.clean.application.mapper.IPictureMapper;
import com.pragma.challenge.clean.common.exception.RequestException;
import com.pragma.challenge.clean.domain.api.IPictureServicePort;
import com.pragma.challenge.clean.domain.model.Picture;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PictureHandlerImpl implements IPictureHandler {

    private final IPictureServicePort pictureServicePort;

    private final IPictureMapper pictureMapper;

    @Value("${project.image}")
    private String path;

    @Override
    public void savePicture(PictureRequest pictureRequest) {
        Picture picture = pictureMapper.toPicture(pictureRequest);
        if(pictureServicePort.getPictureByIdentificationNumber(picture.getIdentificationNumber()) != null){
            throw new RequestException("P-409", "The picture with that identification number already exists", HttpStatus.CONFLICT);
        }
        if(pictureRequest.getImageFile() == null){
            throw new RequestException("P-410", "The image file is required", HttpStatus.BAD_REQUEST);
        }

        picture.setCreatedDate(new Date());
        picture.setPictureName(uploadImage(pictureRequest.getImageFile(), pictureRequest.getIdentificationNumber()));
        pictureServicePort.savePicture(picture);
    }

    public String uploadImage(MultipartFile file, String in) {
        String nameImage = file.getOriginalFilename();

        String randomId = UUID.randomUUID().toString();
        String fileName = in + randomId.concat(nameImage.substring(nameImage.lastIndexOf(".")));

        String filePath = path + File.separator + fileName;

        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }

    @Override
    public List<PictureResponse> getAllPictures() {
        List<Picture> pictureList = pictureServicePort.getAllPictures();
        if(pictureList.isEmpty()){
            throw new RequestException("P-404", "No pictures found", HttpStatus.NOT_FOUND);
        }
        return pictureMapper.toPictureResponseList(pictureServicePort.getAllPictures());
    }

    @Override
    public PictureResponse getPictureByIdentificationNumber(String in) {
        Picture picture = pictureServicePort.getPictureByIdentificationNumber(in);
        if(picture == null){
            throw new RequestException("P-404", "No picture found with that identification number", HttpStatus.NOT_FOUND);
        }
        return pictureMapper.toPictureResponse(pictureServicePort.getPictureByIdentificationNumber(in));
    }

    @Override
    public InputStream getImageResource(String in) {
        Picture currentPicture = pictureServicePort.getPictureByIdentificationNumber(in);
        if(currentPicture == null){
            throw new RequestException("P-404", "No picture found with that identification number", HttpStatus.NOT_FOUND);
        }
        String fileName = currentPicture.getPictureName();

        String fullPath = path + File.separator + fileName;
        InputStream is;

        try {
            is = new FileInputStream(fullPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return is;
    }

    @Override
    public void updatePictureByIdentificationNumber(String in, MultipartFile imageFile) {
        Picture currentPicture = pictureServicePort.getPictureByIdentificationNumber(in);
        if(currentPicture == null){
            throw new RequestException("P-404", "No picture found with that identification number", HttpStatus.NOT_FOUND);
        }
        if(imageFile == null){
            throw new RequestException("P-410", "The image file is required", HttpStatus.BAD_REQUEST);
        }
        deleteImageInDisk(currentPicture.getPictureName());
        String fileName = uploadImage(imageFile, in);
        currentPicture.setPictureName(fileName);

        pictureServicePort.savePicture(currentPicture);

    }


    @Override
    public void deletePictureByIdentificationNumber(String in) {
        Picture currentPicture = pictureServicePort.getPictureByIdentificationNumber(in);
        if(currentPicture == null){
            throw new RequestException("P-404", "No picture found with that identification number", HttpStatus.NOT_FOUND);
        }
        deleteImageInDisk(currentPicture.getPictureName());
        pictureServicePort.deletePictureByIdentificationNumber(in);
    }

    public void deleteImageInDisk(String nameImage) {
        String fullPath = path + File.separator + nameImage;
        File file = new File(fullPath);
        file.delete();

    }
}
