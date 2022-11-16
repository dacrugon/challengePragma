package com.pragma.challenge.clean.infrastructure.output.jpa.repository;

import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByIdentificationNumber(String in);

    @Query(
            value = " SELECT * " +
                    " FROM people " +
                    " WHERE timestampdiff(year, date_birth, curdate()) >= :age ",
            countQuery = " select count(*) from person",
            nativeQuery = true
    )
    List<PersonEntity> findPeopleByAgeGreaterThanOrEqualsTo(Integer age);

    void deleteByIdentificationNumber(String in);
}
