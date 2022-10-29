package com.pragma.challenge.clean.domain.api;

import com.pragma.challenge.clean.domain.model.Person;

import java.util.List;

public interface IPersonServicePort {

    void savePerson(Person person);

    List<Person> getAllPersons();

    List<Person> getPeopleAgeGreaterThanOrEqualsTo(Integer age);

    Person getPersonByIdentificationNumber(String in);

    void updatePerson(Person person);

    void deletePersonByIdentificationNumber(String in);
}
