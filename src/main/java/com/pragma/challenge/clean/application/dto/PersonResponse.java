package com.pragma.challenge.clean.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonResponse {

    private String name;
    private String lastName;
    private String identificationType;
    private String identificationNumber;
    private Date dateBirth;
    private String cityBirth;
    private Date createdDate;
}
