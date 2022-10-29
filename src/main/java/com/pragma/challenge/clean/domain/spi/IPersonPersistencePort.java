package com.pragma.challenge.clean.domain.spi;

import com.pragma.challenge.clean.domain.model.Person;

import java.util.List;

public interface IPersonPersistencePort {

    void savePerson(Person person);

    List<Person> getAllPersons();

    List<Person> getPeopleAgeGreaterThanOrEqualsTo(Integer age);

    Person getPersonByIdentificationNumber(String id);

    void updatePerson(Person person);

    void deletePersonByIdentificationNumber(String id);


}
