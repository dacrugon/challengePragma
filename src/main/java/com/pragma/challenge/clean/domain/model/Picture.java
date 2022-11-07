package com.pragma.challenge.clean.domain.model;


import java.util.Date;

public class Picture {

    private String id;
    private String identificationNumber;
    private String pictureName;
    private Date createdDate;

    public Picture(String id, String identificationNumber, String pictureName, Date createdDate) {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.pictureName = pictureName;
        this.createdDate = createdDate;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
