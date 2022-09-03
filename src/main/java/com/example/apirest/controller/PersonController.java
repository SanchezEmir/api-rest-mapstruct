package com.example.apirest.controller;

import com.example.apirest.dto.PersonDto;
import com.example.apirest.model.Person;
import com.example.apirest.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    public ResponseEntity<?> findAllPersons(){
        response.clear();
        response.put("people", personService.getAllPerson());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id){
        response.clear();
        response.put("person", personService.getPersonById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> savePerson(@Valid @RequestBody PersonDto personDto){
        response.clear();
        personService.savePerson(personDto);
        response.put("message", "Save successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id,@RequestBody PersonDto personDto){
        response.clear();
        personService.updatePerson(id,personDto);
        response.put("message", "update successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id){
        response.clear();
        personService.deletePerson(id);
        response.put("message", "delete successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


}
