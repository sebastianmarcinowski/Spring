package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonRestController {
    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/{index}")
    public ResponseEntity<Person> getPerson(@PathVariable int index) {
        Person person = personService.getPerson(index);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        if (person.getFirstName() == null || person.getFirstName().isBlank() ||
                person.getLastName() == null || person.getLastName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            personService.addPerson(person);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{index}")
    public ResponseEntity<Person> updatePerson(@PathVariable int index, @RequestBody Person person) {
        if (person.getFirstName() == null || person.getFirstName().isBlank() ||
                person.getLastName() == null || person.getLastName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        boolean updated = personService.setPerson(index, person);
        if (!updated) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> removePerson(@PathVariable int index) {
        boolean removed = personService.removePerson(index);
        if (!removed) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
