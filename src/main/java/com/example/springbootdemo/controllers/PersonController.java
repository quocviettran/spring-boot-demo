package com.example.springbootdemo.controllers;

import com.example.springbootdemo.model.Catalogue;
import com.example.springbootdemo.model.Person;
import com.example.springbootdemo.services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value="/all")
    @ResponseBody
    public ResponseEntity<String> getAllCatalogue() throws JsonProcessingException {
        List<Person> personList = personService.getAll();
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(personList), HttpStatus.OK);
    }

    @GetMapping(value="/{personId}")
    @ResponseBody
    public ResponseEntity<String> getById(@PathVariable Long personId) throws JsonProcessingException {
        Person person = personService.findById(personId);
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(person), HttpStatus.OK);
    }


}
