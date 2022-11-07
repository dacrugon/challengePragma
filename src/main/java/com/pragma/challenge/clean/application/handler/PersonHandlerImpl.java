package com.pragma.challenge.clean.application.handler;

import com.pragma.challenge.clean.application.dto.PersonRequest;
import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.application.mapper.IPersonMapper;
import com.pragma.challenge.clean.domain.api.IPersonServicePort;
import com.pragma.challenge.clean.domain.model.Person;
import lombok.RequiredArgsConstructor;
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
        person.setCreatedDate(new Date());
        personServicePort.savePerson(person);
    }

    @Override
    public List<PersonResponse> getAllPersons() {
        return personMapper.toListPersonResponse(personServicePort.getAllPersons());

    }

    @Override
    public List<PersonResponse> findPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        return personMapper.toListPersonResponse(personServicePort.findPeopleByAgeGreaterThanOrEqualsTo(age));
    }

    @Override
    public PersonResponse getPersonByIdentificationNumber(String in) {
        return personMapper.toPersonResponse(personServicePort.getPersonByIdentificationNumber(in));
    }

    @Override
    public void updatePerson(PersonRequest personRequest, String in) {
        Person currentPerson = personServicePort.getPersonByIdentificationNumber(in);
        Person person = personMapper.toPerson(personRequest);
        Person personUpdated;

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
        personServicePort.deletePersonByIdentificationNumber(in);
    }
}
