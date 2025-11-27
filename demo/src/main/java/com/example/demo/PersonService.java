package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> people;

    @PostConstruct
    public void init(){
        people = new ArrayList<Person>();
        people.add(new Person("Jan", "Kowalski"));
        people.add(new Person("Anna", "Nowak"));
        people.add(new Person("Maciek", "Zieliński"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int index) {
        return people.get(index);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public boolean setPerson(int index, Person person) {
        if (index < 0 || index >= people.size()) {
            return false;
        }
        people.set(index, person);
        return true;
    }

    public boolean removePerson(int index) {
        if (index < 0 || index >= people.size()) {
            return false;
        }
        people.remove(index);
        return true;
    }
}
