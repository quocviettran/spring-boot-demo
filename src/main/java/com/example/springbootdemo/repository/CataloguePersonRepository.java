package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.CataloguePerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CataloguePersonRepository extends JpaRepository<CataloguePerson, Long> {

    List<CataloguePerson> findCataloguePersonByCatalogueId(Long catalogueId);
}
