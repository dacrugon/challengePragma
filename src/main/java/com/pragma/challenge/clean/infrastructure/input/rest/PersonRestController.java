package com.pragma.challenge.clean.infrastructure.input.rest;

import com.pragma.challenge.clean.application.dto.PersonRequest;
import com.pragma.challenge.clean.application.dto.PersonResponse;
import com.pragma.challenge.clean.application.handler.IPersonHandler;
import com.pragma.challenge.clean.common.response.ResponseHandler;
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
    public ResponseEntity<Object> savePerson(PersonRequest personRequest){
        personHandler.savePerson(personRequest);
        return ResponseHandler.generateResponseWithoutData("P-201","successful", HttpStatus.OK);
    }
    @GetMapping("/people")
    public ResponseEntity<Object> getAllPersons(){
        return ResponseHandler.generateResponseWithData("P-201","successful",personHandler.getAllPersons(),HttpStatus.OK);
    }
    @GetMapping("/people/{in}")
    public ResponseEntity<Object> getPersonByIdentificationNumber(@PathVariable String in){
        return ResponseHandler.generateResponseWithData("P-201","successful",personHandler.getPersonByIdentificationNumber(in),HttpStatus.OK);
    }
    @GetMapping("/people/greaterThanOrEqualTo/{age}")
    public ResponseEntity<Object> getPeopleByAgeGreaterThanOrEqualsTo(@PathVariable Integer age){
        return ResponseHandler.generateResponseWithData("P-201","successful",personHandler.findPeopleByAgeGreaterThanOrEqualsTo(age),HttpStatus.OK);
    }
    @PutMapping("/people/{in}")
    public ResponseEntity<Object> updatePerson(PersonRequest personRequest, @PathVariable String in){
        personHandler.updatePerson(personRequest,in);
        return ResponseHandler.generateResponseWithoutData("P-202","Updated",HttpStatus.OK);
    }
    @DeleteMapping("people/{in}")
    public ResponseEntity<Object> deletePersonByIdentificationNumber(@PathVariable String in){
        personHandler.deletePersonByIdentificationNumber(in);
        return ResponseHandler.generateResponseWithoutData("P-203","Deleted",HttpStatus.OK);
    }
}
