package com.pragma.challenge.clean.infrastructure.output.jpa.mapper;

import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPersonEntityMapper {
    PersonEntity toEntity(Person person);
    Person toPerson(PersonEntity personEntity);
    List<Person> toPersonList(List<PersonEntity> personEntityList);
}
