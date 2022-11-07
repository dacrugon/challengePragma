package com.pragma.challenge.clean.infrastructure.output.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "people")
@Getter
@Setter
public class PersonEntity {

    @Id
    @Column(name = "idperson")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "identification_type", length = 20, nullable = false)
    private String identificationType;
    @Column(name = "identification_number", length = 20, nullable = false)
    private String identificationNumber;
    @Column(name = "date_birth", nullable = false)
    private Date dateBirth;
    @Column(name = "city_birth", nullable = false)
    private String cityBirth;
    @Column(name = "create_at", nullable = false)
    private Date createdDate;
}

