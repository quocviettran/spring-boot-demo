package com.example.springbootdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    private Long id;
    private String name;
    private Integer age;

    protected Person() { }


    public Person(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() { return id; }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void birthday() {
        age++;
    }

    @Override
    public String toString() {
        return String.format("Person-id:%d - %s(%d)", id, name, age);
    }
}
