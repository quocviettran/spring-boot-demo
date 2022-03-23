package com.example.springbootdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CataloguePerson {
    @Id
    private Long id;
    private Long personId;
    private Long catalogueId;

    public CataloguePerson() {}

    public CataloguePerson(Long id, Long personId, Long catalogueId){
        this.id = id;
        this.personId = personId;
        this.catalogueId = catalogueId;
    }

    public Long getId() {
        return id;
    }

    public Long getPersonId() {
        return personId;
    }

    public Long getCatalogueId() {
        return catalogueId;
    }
}
