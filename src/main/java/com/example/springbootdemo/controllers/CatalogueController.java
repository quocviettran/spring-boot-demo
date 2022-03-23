package com.example.springbootdemo.controllers;

import com.example.springbootdemo.model.Catalogue;
import com.example.springbootdemo.model.Person;
import com.example.springbootdemo.services.CatalogueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/catalogue")
public class CatalogueController {

    public final CatalogueService catalogueService;

    public CatalogueController(CatalogueService catalogueService){
        this.catalogueService = catalogueService;
    }

    @GetMapping(value="/all")
    @ResponseBody
    public ResponseEntity<String> getAllCatalogue() throws JsonProcessingException {
        List<Catalogue> catalogue = catalogueService.getAllCatalogue();
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(catalogue), HttpStatus.OK);
    }

    @GetMapping(value = "/{catalogueId}")
    @ResponseBody
    public ResponseEntity<String> getAllInCatalogueById(@PathVariable Long catalogueId) throws JsonProcessingException {
        Catalogue catalogue = catalogueService.findCatalogueById(catalogueId);
        List<Person> personList = catalogueService.findAllInCatalogue(catalogue);
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(personList), HttpStatus.OK);
    }
}
