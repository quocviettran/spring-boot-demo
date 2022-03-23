package com.example.springbootdemo.services;

import com.example.springbootdemo.model.Catalogue;
import com.example.springbootdemo.model.CataloguePerson;
import com.example.springbootdemo.model.Person;
import com.example.springbootdemo.repository.CataloguePersonRepository;
import com.example.springbootdemo.repository.CatalogueRepository;
import com.example.springbootdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogueService {

    private final CatalogueRepository catalogueRepository;
    private final PersonRepository personRepository;
    private final CataloguePersonRepository cataloguePersonRepository;

    public CatalogueService(CatalogueRepository catalogueRepository, PersonRepository personRepository, CataloguePersonRepository cataloguePersonRepository, EntityManager entityManager) {
        this.catalogueRepository = catalogueRepository;
        this.personRepository = personRepository;
        this.cataloguePersonRepository = cataloguePersonRepository;
    }

    public List<Catalogue> getAllCatalogue() { return catalogueRepository.findAll();}

    public Catalogue findCatalogueById(Long catalogueId) { return catalogueRepository.findById(catalogueId);}

    public List<Person> findAllInCatalogue(Catalogue catalogue){
        List<CataloguePerson> allPersonInCatalogue = cataloguePersonRepository.findCataloguePersonByCatalogueId(catalogue.getId());
        List<Long> allIds = new ArrayList<>();
        for (CataloguePerson person : allPersonInCatalogue) {
            allIds.add(person.getPersonId());
        }
        return personRepository.findAllById(allIds);
    }

    public void deletePersonIdInCatalogue(int id){
        personRepository.deleteById(id);
    }


}
