package com.pragma.challenge.clean.infrastructure.input.rest;

import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.application.dto.PictureRequest;
import com.pragma.challenge.clean.application.dto.PictureResponse;
import com.pragma.challenge.clean.application.handler.IPictureHandler;
import com.pragma.challenge.clean.domain.model.Picture;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PictureRestController {

    private final IPictureHandler pictureHandler;

    @Value("${project.image}")
    private String path;

    @PostMapping("/pictures")
    public ResponseEntity<Void> savePicture(PictureRequest pictureRequest){
        pictureHandler.savePicture(pictureRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/pictures")
    public ResponseEntity<List<PictureResponse>> getPictures(){
       return ResponseEntity.ok(pictureHandler.getAllPictures());
    }

    @GetMapping("/pictures/{in}")
    public ResponseEntity<PictureResponse> getPictureByIdentificationNumber(@PathVariable String in){
        return ResponseEntity.ok(pictureHandler.getPictureByIdentificationNumber(in));
    }

    @GetMapping(value="/pictures/download/{in}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadPictureByIdentificationNumber(@PathVariable String in, HttpServletResponse response){
        InputStream resource = pictureHandler.getImageResource(in);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        try {
            StreamUtils.copy(resource, response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/pictures/{in}")
    public void updatePictureByIdentificationNumber(@PathVariable String in, MultipartFile imageFile){
        pictureHandler.updatePictureByIdentificationNumber(in,imageFile);
    }

    @DeleteMapping("/pictures/{in}")
    public void deletePictureByIdentificationNumber(@PathVariable String in){
        pictureHandler.deletePictureByIdentificationNumber(in);
    }

}
