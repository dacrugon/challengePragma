package com.pragma.challenge.clean.domain.model;


import java.time.LocalDateTime;

public class Picture {

    private String id;
    private String identificationNumber;
    private String pictureName;
    private LocalDateTime createdDate = LocalDateTime.now();

    public Picture(String id, String identificationNumber, String pictureName, LocalDateTime createdDate) {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.pictureName = pictureName;
        this.createdDate = createdDate;
    }

    public Picture() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
