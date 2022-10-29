package com.pragma.challenge.clean.application.mapper;

import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.domain.model.Person;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PersonResponseMapper {

        @Mappings({
                @Mapping(source = "name", target = "name"),
                @Mapping(source = "lastName", target = "lastName"),
                @Mapping(source = "identificationType", target = "identificationType"),
                @Mapping(source = "identificationNumber", target = "identificationNumber"),
                @Mapping(source = "dateBirth", target = "dateBirth"),
                @Mapping(source = "cityBirth", target = "cityBirth"),
        })
        PersonResponse toPersonResponse(Person person);
        @InheritInverseConfiguration
        Person toPerson(PersonResponse personResponse);

}
