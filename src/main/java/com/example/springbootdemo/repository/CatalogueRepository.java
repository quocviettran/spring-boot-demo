package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Catalogue;
import com.example.springbootdemo.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CatalogueRepository {
    public JdbcTemplate jdbcTemplate;

    public CatalogueRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class CatalogueRowMapper implements RowMapper<Catalogue> {
        @Override
        public Catalogue mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Catalogue(
                    rs.getLong("id"),
                    rs.getString("name")
            );
        }
    }

    public List<Catalogue> findAll() {
        return jdbcTemplate.query("select * from catalogue", new CatalogueRowMapper());
    }

    public Catalogue findById(Long catalogueId) {
        return jdbcTemplate.queryForObject("select * from catalogue where id = ?", new CatalogueRowMapper(), catalogueId);
    }


}
