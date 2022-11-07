package com.pragma.challenge.clean.application.mapper;

import com.pragma.challenge.clean.application.dto.PersonRequest;
import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.domain.model.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPersonMapper {


    Person toPerson(PersonRequest personRequest);

    PersonResponse toPersonResponse(Person person);

    List<PersonResponse> toListPersonResponse(List<Person> person);


}
