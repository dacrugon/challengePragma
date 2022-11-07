package com.pragma.challenge.clean.application.handler;

import com.pragma.challenge.clean.application.dto.PersonRequest;
import com.pragma.challenge.clean.application.dto.PersonResponse;

import java.util.List;

public interface IPersonHandler {

    void savePerson(PersonRequest personRequest);
    List<PersonResponse> getAllPersons();

    /*List<PersonResponse> getPeopleByAgeGreaterThanOrEqualsTo(Integer age);*/

    PersonResponse getPersonByIdentificationNumber(String in);
    void updatePerson(PersonRequest personRequest, String in);
    void deletePersonByIdentificationNumber(String in);
}
