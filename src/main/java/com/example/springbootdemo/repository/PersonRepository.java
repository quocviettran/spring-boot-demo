package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepository {

    public JdbcTemplate jdbcTemplate;
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getInt("age")
            );
            return person;
        }
    }

    public List<Person> findAll() {
        List<Person> results = jdbcTemplate.query("select * from person", new PersonRowMapper());
        return results;
    }

    public Person findById(Long id) {
        try {
            Person person = jdbcTemplate.queryForObject("select * from person where id=?", new PersonRowMapper(), id);
            return person;
        } catch(Exception e) {
            e.getMessage();
        }
        return null;
    }

    public List<Person> findAllById(List<Long> ids) {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", ids);
        return namedParameterJdbcTemplate.query("select * from person where id in (:ids)", parameters, new PersonRowMapper());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?",id);
    }

    public void insert(@NotNull Person person) {
        jdbcTemplate.update("insert into person(name,age) values (?,?)", person.getName(), person.getAge());
    }

    public int count() {
        return jdbcTemplate.queryForObject("select COUNT(*) from person", Integer.class);
    }
}
