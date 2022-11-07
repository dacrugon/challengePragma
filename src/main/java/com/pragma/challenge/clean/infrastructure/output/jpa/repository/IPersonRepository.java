package com.pragma.challenge.clean.infrastructure.output.jpa.repository;

import com.pragma.challenge.clean.domain.model.Person;
import com.pragma.challenge.clean.infrastructure.output.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByIdentificationNumber(String in);

/*    @Query("SELECT p FROM Person p WHERE timestampdiff(year, p.dateBirth, curdate()) >= ?1")*/
    @Query(
            value = " SELECT * " +
                    " FROM people " +
                    " WHERE timestampdiff(year, date_birth, curdate()) >= :age ",
            countQuery = " select count(*) from person",
            nativeQuery = true
    )
    Optional<PersonEntity> findPeopleByAgeGreaterThanOrEqualsTo(Integer age);

    void deleteByIdentificationNumber(String in);
}
