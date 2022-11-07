package com.pragma.challenge.clean.infrastructure.output.jpa.repository;

import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository extends JpaRepository<PersonEntity,Long> {

    Optional<PersonEntity> findByIdentificationNumber(String in);

    /*Optional<PersonEntity> findPeopleByAgeGreaterThanOrEqualsTo(Integer age);*/

    void deleteByIdentificationNumber(String in);
}
