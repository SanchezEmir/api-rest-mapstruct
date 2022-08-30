package com.example.apirest.service;

import com.example.apirest.model.Person;

import java.util.List;

public interface IPersonService {

    Person getPersonById(Long id);

    List<Person> getAllPerson();

    void savePerson(Person person);

    void updatePerson(Long id, Person person);

    void deletePerson(Long id);

}
