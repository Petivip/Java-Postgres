package com.example.demodemo.doa;

import com.example.demodemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class FakeDataAccessPersonDoa implements PersonDoa {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {

        return  DB.stream().filter(person -> person.getId().equals(id)).findFirst();

    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> makePerson=getPersonById(id);

        if(makePerson.isEmpty()){
            return 0;
        }

        DB.remove(makePerson.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return getPersonById(id).map(p -> {
            int index=DB.indexOf(p);
            if (index>=0){
                DB.set(index, person);
                return 1;
            }

            return 0;
        }).orElse(0);
    }


}
