package com.pragma.challenge.clean.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
public class PictureRequest {
    private String identificationNumber;
    private MultipartFile imageFile;

}
