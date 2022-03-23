package com.example.springbootdemo.services;

import com.example.springbootdemo.model.Person;
import com.example.springbootdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public final PersonRepository personRepository;

    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) { return personRepository.findById(id);}

}
