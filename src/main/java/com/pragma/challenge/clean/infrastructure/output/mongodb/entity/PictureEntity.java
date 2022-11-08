package com.pragma.challenge.clean.infrastructure.output.mongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "pictures")
@Getter
@Setter
public class PictureEntity {
    @Id
    private String id;
    private String identificationNumber;
    private String pictureName;
    private LocalDateTime createdDate = LocalDateTime.now();
}
