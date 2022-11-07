package com.pragma.challenge.clean.infrastructure.output.jpa.adapter;

import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;
import com.pragma.challenge.clean.infrastructure.exception.NoDataFoundException;
import com.pragma.challenge.clean.infrastructure.exception.PersonAlreadyExistsException;
import com.pragma.challenge.clean.infrastructure.exception.PersonNotFoundException;
import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import com.pragma.challenge.clean.infrastructure.output.jpa.repository.IPersonRepository;
import com.pragma.challenge.clean.infrastructure.output.jpa.mapper.IPersonEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonJpaAdapter implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper IPersonEntityMapper;

    @Override
    public void savePerson(Person person) {
        if(personRepository.findByIdentificationNumber(person.getIdentificationNumber()).isPresent()){
            throw new PersonAlreadyExistsException();
        }
        personRepository.save(IPersonEntityMapper.toEntity(person));
    }

    @Override
    public List<Person> getAllPersons() {
        List<PersonEntity> personEntityList = personRepository.findAll();
        if(personEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return IPersonEntityMapper.toPersonList(personEntityList);
    }

    @Override
    public List<Person> findPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        Optional<PersonEntity> personEntity = personRepository.findPeopleByAgeGreaterThanOrEqualsTo(age);
        if(personEntity.isEmpty()){
            throw new NoDataFoundException();
        }
        return IPersonEntityMapper.toPersonList(List.of(personEntity.get()));
    }


    @Override
    public Person getPersonByIdentificationNumber(String in) {
        return IPersonEntityMapper.toPerson(personRepository.findByIdentificationNumber(in).orElseThrow(PersonNotFoundException::new));
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
