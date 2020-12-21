package com.example.demodemo.api;


import com.example.demodemo.model.Person;
import com.example.demodemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api")
@RestController
public class HomeController {

    private final PersonService personService;

    @Autowired
    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> addAllPeople(){
        return personService.addAllPeople();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> selectPersonById(@PathVariable("id")UUID id){
        return personService.getPersonById(id);

    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id){
        personService.deleteById(id);
    }

    @PutMapping({"{id"})
    public void updatePersonId(@PathVariable("id") UUID id,@NonNull @RequestBody Person person){
        personService.updatePersonById(id, person);
    }
}
