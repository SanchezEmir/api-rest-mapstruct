package com.example.apirest.service;

import com.example.apirest.dto.PersonDto;
import com.example.apirest.model.Person;

import java.util.List;

public interface IPersonService {

    PersonDto getPersonById(Long id);

    List<Person> getAllPerson();

    void savePerson(PersonDto personDto);

    void updatePerson(Long id, PersonDto personDto);

    void deletePerson(Long id);

}
