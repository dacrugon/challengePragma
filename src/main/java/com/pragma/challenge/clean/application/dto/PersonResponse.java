package com.pragma.challenge.clean.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponse {

    private String name;
    private String lastName;
    private String identificationType;
    private String identificationNumber;
    private String dateBirth;
    private String cityBirth;
}
