package com.example.apirest.service.impl;

import com.example.apirest.dto.PersonDto;
import com.example.apirest.exception.NotFoundException;
import com.example.apirest.mapper.PersonMapper;
import com.example.apirest.model.Person;
import com.example.apirest.repository.IPersonRepository;
import com.example.apirest.service.IPersonService;
import com.example.apirest.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceImpl implements IPersonService {

//    @Autowired
//    private IPersonRepository personRepository;
//    @Autowired
//    private MessageUtil messageUtil;
//    @Autowired
//    private PersonMapper personMapper;


    private final IPersonRepository personRepository;

    private final MessageUtil messageUtil;

    private final PersonMapper personMapper;

    public PersonServiceImpl(IPersonRepository personRepository, MessageUtil messageUtil, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.messageUtil = messageUtil;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        return personMapper.toDto(personRepository.findById(id).orElseThrow(
                () -> new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
        ));
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, PersonDto personDto) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Person not found")
        );
        personMapper.updateEntity(personDto, person1);
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
