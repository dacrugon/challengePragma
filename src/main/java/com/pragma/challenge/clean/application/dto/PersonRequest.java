package com.pragma.challenge.clean.application.dto;

import com.pragma.challenge.clean.domain.model.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PersonRequest {

    private String name;
    private String lastName;
    private String identificationType;
    private String identificationNumber;
    private Date dateBirth;
    private String cityBirth;
}
