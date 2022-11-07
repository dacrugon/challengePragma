package com.pragma.challenge.clean.domain.usecase;

import com.pragma.challenge.clean.domain.api.IPersonServicePort;
import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;

import java.util.List;

public class PersonUseCase implements IPersonServicePort {

    private final IPersonPersistencePort personPersistencePort;

    public PersonUseCase(IPersonPersistencePort personPersistencePort) {
        this.personPersistencePort = personPersistencePort;
    }

    @Override
    public void savePerson(Person person) {
        personPersistencePort.savePerson(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personPersistencePort.getAllPersons();
    }

/*    @Override
    public List<Person> getPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        return personPersistencePort.getPeopleByAgeGreaterThanOrEqualsTo(age);
    }*/


    @Override
    public Person getPersonByIdentificationNumber(String in) {
        return personPersistencePort.getPersonByIdentificationNumber(in);
    }

    @Override
    public void deletePersonByIdentificationNumber(String in) {
        personPersistencePort.deletePersonByIdentificationNumber(in);
    }

    @Override
    public void updatePerson(Person person) {
        personPersistencePort.updatePerson(person);
    }
}
