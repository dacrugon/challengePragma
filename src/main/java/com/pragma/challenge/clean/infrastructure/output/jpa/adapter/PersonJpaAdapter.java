package com.pragma.challenge.clean.infrastructure.output.jpa.adapter;

import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;
import com.pragma.challenge.clean.infrastructure.exception.NoDataFoundException;
import com.pragma.challenge.clean.infrastructure.exception.PersonAlreadyExistsException;
import com.pragma.challenge.clean.infrastructure.exception.PersonNotFoundException;
import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import com.pragma.challenge.clean.infrastructure.output.jpa.mapper.PersonEntityMapper;
import com.pragma.challenge.clean.infrastructure.output.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonJpaAdapter implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final PersonEntityMapper personEntityMapper;

    @Override
    public void savePerson(Person person) {
        if(personRepository.findByIdentificationNumber(person.getIdentificationNumber()).isPresent()){
            throw new PersonAlreadyExistsException();
        }
        personRepository.save(personEntityMapper.toEntity(person));
    }

    @Override
    public List<Person> getAllPersons() {
        List<PersonEntity> personEntityList = personRepository.findAll();
        if(personEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return personEntityMapper.toPersonList(personEntityList);
    }

/*    @Override
    public List<Person> getPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        Optional<PersonEntity> personEntity = personRepository.findPeopleByAgeGreaterThanOrEqualsTo(age);
        if(personEntity.isEmpty()){
            throw new NoDataFoundException();
        }
        return personEntityMapper.toPersonList(List.of(personEntity.get()));
    }*/


    @Override
    public Person getPersonByIdentificationNumber(String in) {
        return personEntityMapper.toPerson(personRepository.findByIdentificationNumber(in).orElseThrow(PersonNotFoundException::new));
    }


    @Override
    public void deletePersonByIdentificationNumber(String in) {
        personRepository.deleteByIdentificationNumber(in);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(personEntityMapper.toEntity(person));
    }
}
