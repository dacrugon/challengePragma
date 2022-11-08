package com.pragma.challenge.clean.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PictureResponse {
    private String identificationNumber;
    private String pictureName;
    private Date createdDate;
}
