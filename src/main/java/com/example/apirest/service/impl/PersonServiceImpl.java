package com.example.apirest.service.impl;

import com.example.apirest.exception.NotFoundException;
import com.example.apirest.model.Person;
import com.example.apirest.repository.IPersonRepository;
import com.example.apirest.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found!")
        );
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found")
        );
        person1.setName(person.getName());
        person1.setLastname(person.getLastname());
        personRepository.save(person1);
    }

    @Override
    public void deletePerson(Long id) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found")
        );
        personRepository.deleteById(id);
    }
}
