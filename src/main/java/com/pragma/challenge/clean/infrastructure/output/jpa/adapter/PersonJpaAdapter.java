package com.pragma.challenge.clean.infrastructure.output.jpa.adapter;

import com.pragma.challenge.clean.common.exception.RequestException;
import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;

import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import com.pragma.challenge.clean.infrastructure.output.jpa.repository.IPersonRepository;
import com.pragma.challenge.clean.infrastructure.output.jpa.mapper.IPersonEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PersonJpaAdapter implements IPersonPersistencePort {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper IPersonEntityMapper;

    @Override
    public void savePerson(Person person) {
        if(personRepository.findByIdentificationNumber(person.getIdentificationNumber()).isPresent()){
            throw new RequestException("P-409","Person already exists", HttpStatus.CONFLICT);
        }
        personRepository.save(IPersonEntityMapper.toEntity(person));
    }

    @Override
    public List<Person> getAllPersons() {
        List<PersonEntity> personEntityList = personRepository.findAll();
        if(personEntityList.isEmpty()){
            throw new RequestException("P-404","No persons found", HttpStatus.NOT_FOUND);
        }
        return IPersonEntityMapper.toPersonList(personEntityList);
    }

    @Override
    public List<Person> findPeopleByAgeGreaterThanOrEqualsTo(Integer age) {
        Optional<PersonEntity> personEntity = personRepository.findPeopleByAgeGreaterThanOrEqualsTo(age);
        if(personEntity.isEmpty()){
            throw new RequestException("P-404","No persons found", HttpStatus.NOT_FOUND);
        }
        return IPersonEntityMapper.toPersonList(List.of(personEntity.get()));
    }


    @Override
    public Person getPersonByIdentificationNumber(String in) {
        return IPersonEntityMapper.toPerson(personRepository.findByIdentificationNumber(in).orElseThrow(()->new RequestException("P-404","Person not found", HttpStatus.NOT_FOUND)));
    }


    @Override
    public void deletePersonByIdentificationNumber(String in) {
        personRepository.findByIdentificationNumber(in).orElseThrow(()->new RequestException("P-404","Person not found", HttpStatus.NOT_FOUND));

        personRepository.deleteByIdentificationNumber(in);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.findByIdentificationNumber(person.getIdentificationNumber()).orElseThrow(()->new RequestException("P-404","Person not found", HttpStatus.NOT_FOUND));
        personRepository.save(IPersonEntityMapper.toEntity(person));
    }
}
