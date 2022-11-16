package com.pragma.challenge.clean.application.handler;

import com.pragma.challenge.clean.application.dto.PersonRequest;
import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.application.mapper.IPersonMapper;
import com.pragma.challenge.clean.common.exception.RequestException;
import com.pragma.challenge.clean.domain.api.IPersonServicePort;
import com.pragma.challenge.clean.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonHandlerImpl implements IPersonHandler {

    private final IPersonServicePort personServicePort;

    private final IPersonMapper personMapper;

    @Override
    public void savePerson(PersonRequest personRequest) {
        Person person = personMapper.toPerson(personRequest);
        if (personServicePort.getPersonByIdentificationNumber(person.getIdentificationNumber()) != null) {
            throw new RequestException("P-409", "Person already exists", HttpStatus.CONFLICT);
        }
        person.setCreatedDate(new Date());
        personServicePort.savePerson(person);
    }

    @Override
    public List<PersonResponse> getAllPersons() {
        List<Person> personList = personServicePort.getAllPersons();
        if (personList.isEmpty()) {
            throw new RequestException("P-404", "No persons found", HttpStatus.NOT_FOUND);
        }
        return personMapper.toListPersonResponse(personList);
    }

    @Override
    public List<PersonResponse> findPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        List<Person> person = personServicePort.findPeopleByAgeGreaterThanOrEqualsTo(age);
        if (person.isEmpty()) {
            throw new RequestException("P-404", "No persons found", HttpStatus.NOT_FOUND);
        }
        return personMapper.toListPersonResponse(person);
    }

    @Override
    public PersonResponse getPersonByIdentificationNumber(String in) {
        Person person = personServicePort.getPersonByIdentificationNumber(in);
        if (person == null) {
            throw new RequestException("P-404", "Person not found", HttpStatus.NOT_FOUND);
        }
        return personMapper.toPersonResponse(person);
    }

    @Override
    public void updatePerson(PersonRequest personRequest, String in) {
        Person currentPerson = personServicePort.getPersonByIdentificationNumber(in);
        if (currentPerson == null) {
            throw new RequestException("P-404", "Person not found", HttpStatus.NOT_FOUND);
        }
        Person person = personMapper.toPerson(personRequest);

        currentPerson.setLastName(person.getLastName());
        currentPerson.setName(person.getName());
        currentPerson.setIdentificationType(person.getIdentificationType());
        currentPerson.setIdentificationNumber(person.getIdentificationNumber());
        currentPerson.setDateBirth(person.getDateBirth());
        currentPerson.setCityBirth(person.getCityBirth());

        personServicePort.updatePerson(currentPerson);
    }

    @Override
    public void deletePersonByIdentificationNumber(String in) {
        Person person = personServicePort.getPersonByIdentificationNumber(in);
        if (person == null) {
            throw new RequestException("P-404", "Person not found", HttpStatus.NOT_FOUND);
        }
        personServicePort.deletePersonByIdentificationNumber(in);
    }
}
