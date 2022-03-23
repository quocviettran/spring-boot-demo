package com.example.springbootdemo.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Catalogue {

    @Id
    private Long id;
    private String name;

    public Catalogue(){}

    public Catalogue(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public String getName() { return name; }

}
