package com.pragma.challenge.clean.domain.model;
import java.time.LocalDateTime;
import java.util.Date;

public class Person {

    private Long id;
    private String name;
    private String lastName;
    private String identificationType;
    private String identificationNumber;
    private Date dateBirth;
    private String cityBirth;
    private LocalDateTime createdDate = LocalDateTime.now();

    public Person(Long id, String name, String lastName, String identificationType, String identificationNumber, Date dateBirth, String cityBirth, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.dateBirth = dateBirth;
        this.cityBirth = cityBirth;
        this.createdDate = createdDate;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCityBirth() {
        return cityBirth;
    }

    public void setCityBirth(String cityBirth) {
        this.cityBirth = cityBirth;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
