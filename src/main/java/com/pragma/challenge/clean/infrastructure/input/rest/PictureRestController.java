package com.pragma.challenge.clean.infrastructure.input.rest;

import com.pragma.challenge.clean.application.dto.PictureRequest;
import com.pragma.challenge.clean.application.handler.IPictureHandler;
import com.pragma.challenge.clean.common.response.ResponseHandler;
import io.swagger.v3.oas.annotations.Operation;
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

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PictureRestController {

    private final IPictureHandler pictureHandler;

    @Value("${project.image}")
    private String path;

    @Operation(summary = "Save a picture")
    @PostMapping("/pictures")
    public ResponseEntity<Object> savePicture(PictureRequest pictureRequest){
        pictureHandler.savePicture(pictureRequest);
        return ResponseHandler.generateResponseWithoutData("P-201","successful", HttpStatus.OK);
    }

    @Operation(summary = "Get all pictures")
    @GetMapping("/pictures")
    public ResponseEntity<Object> getPictures(){
       return ResponseHandler.generateResponseWithData("P-201","successful",pictureHandler.getAllPictures(),HttpStatus.OK);
    }

    @Operation(summary = "Get a picture by identification number")
    @GetMapping("/pictures/{in}")
    public ResponseEntity<Object> getPictureByIdentificationNumber(@PathVariable String in){
        return ResponseHandler.generateResponseWithData("P-201","successful",pictureHandler.getPictureByIdentificationNumber(in),HttpStatus.OK);
    }

    @Operation(summary = "Download a picture by identification number")
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

    @Operation(summary = "Update a picture by identification number")
    @PutMapping("/pictures/{in}")
    public ResponseEntity<Object> updatePictureByIdentificationNumber(@PathVariable String in, MultipartFile imageFile){
        pictureHandler.updatePictureByIdentificationNumber(in,imageFile);
        return ResponseHandler.generateResponseWithoutData("P-202","Updated",HttpStatus.OK);
    }

    @Operation(summary = "Delete a picture by identification number")
    @DeleteMapping("/pictures/{in}")
    public ResponseEntity<Object> deletePictureByIdentificationNumber(@PathVariable String in){
        pictureHandler.deletePictureByIdentificationNumber(in);
        return ResponseHandler.generateResponseWithoutData("P-203","Deleted",HttpStatus.OK);
    }

}
