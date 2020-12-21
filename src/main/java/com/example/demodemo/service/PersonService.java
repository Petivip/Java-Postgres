package com.example.demodemo.service;

import com.example.demodemo.doa.PersonDoa;
import com.example.demodemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PersonService {
    private final PersonDoa personDoa;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDoa personDoa) {
        this.personDoa = personDoa;
    }


    public int addPerson(Person person) {
        return personDoa.insertPerson(person);
    }

    public List<Person> addAllPeople(){
        return personDoa.getAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDoa.getPersonById(id);
    }

    public void deleteById(UUID id){
        personDoa.deletePersonById(id);

    }

    public int updatePersonById(UUID id, Person person){
        return personDoa.updatePerson(id,person);


    }

}
