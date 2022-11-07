package com.pragma.challenge.clean.infrastructure.input.rest;

import com.pragma.challenge.clean.application.dto.PersonRequest;
import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.application.handler.IPersonHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonRestController {
    private final IPersonHandler personHandler;

    @PostMapping("/people")
    public ResponseEntity<Void> savePerson(PersonRequest personRequest){
        personHandler.savePerson(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/people")
    public ResponseEntity<List<PersonResponse>> getAllPersons(){
        return ResponseEntity.ok(personHandler.getAllPersons());
    }
    @GetMapping("/people/{in}")
    public ResponseEntity<PersonResponse> getPersonByIdentificationNumber(@PathVariable String in){
        return ResponseEntity.ok(personHandler.getPersonByIdentificationNumber(in));
    }
    @GetMapping("/people/greaterThanOrEqualTo/{age}")
    public ResponseEntity<List<PersonResponse>> getPeopleByAgeGreaterThanOrEqualsTo(@PathVariable Integer age){
        return ResponseEntity.ok(personHandler.findPeopleByAgeGreaterThanOrEqualsTo(age));
    }
    @PutMapping("/people/{in}")
    public ResponseEntity<Void> updatePerson(PersonRequest personRequest, @PathVariable String in){
        personHandler.updatePerson(personRequest,in);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("people/{in}")
    public ResponseEntity<Void> deletePersonByIdentificationNumber(@PathVariable String in){
        personHandler.deletePersonByIdentificationNumber(in);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
