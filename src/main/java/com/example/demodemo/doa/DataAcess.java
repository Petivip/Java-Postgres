package com.example.demodemo.doa;

import com.example.demodemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class DataAcess implements PersonDoa {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataAcess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        final String sql="SELECT id, name From person";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });

    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        final String sql="SELECT id, name From person  WHERE  id = ?";
        Person person= jdbcTemplate.queryForObject(sql, new Object[]{id},(resultSet, i) -> {
            UUID personid = UUID.fromString(resultSet.getString("id"));
            String personame = resultSet.getString("name");
            return new Person(personid, personame);
        });

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {

        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return 0;
    }
}
