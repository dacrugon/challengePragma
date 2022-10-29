package com.pragma.challenge.clean.application.dto;

import com.pragma.challenge.clean.domain.model.Picture;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

    private String name;
    private String lastName;
    private String identificationType;
    private String identificationNumber;
    private String dateBirth;
    private String cityBirth;

}
