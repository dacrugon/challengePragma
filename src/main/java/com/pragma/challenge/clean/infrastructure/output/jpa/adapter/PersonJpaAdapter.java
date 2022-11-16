package com.pragma.challenge.clean.infrastructure.output.jpa.adapter;

import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;
import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import com.pragma.challenge.clean.infrastructure.output.jpa.mapper.IPersonEntityMapper;
import com.pragma.challenge.clean.infrastructure.output.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonJpaAdapter implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper IPersonEntityMapper;

    @Override
    public void savePerson(Person person) {
        personRepository.save(IPersonEntityMapper.toEntity(person));
    }

    @Override
    public List<Person> getAllPersons() {
        return IPersonEntityMapper.toPersonList(personRepository.findAll());
    }

    @Override
    public List<Person> findPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        return IPersonEntityMapper.toPersonList(personRepository.findPeopleByAgeGreaterThanOrEqualsTo(age));
    }

    @Override
    public Person getPersonByIdentificationNumber(String in) {
        return IPersonEntityMapper.toPerson(personRepository.findByIdentificationNumber(in));
    }

    @Override
    public void deletePersonByIdentificationNumber(String in) {

        personRepository.deleteByIdentificationNumber(in);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(IPersonEntityMapper.toEntity(person));
    }
}
