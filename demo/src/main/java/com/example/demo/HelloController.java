package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class HelloController {

    private final PersonService personService;

    public HelloController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public String list(Model model) {
        model.addAttribute("people", personService.getPeople());
        return "people";
    }

    @GetMapping("/person/{index}")
    public String person(@PathVariable int index, Model model) {
        Person p = personService.getPerson(index);
        model.addAttribute("person", p);
        model.addAttribute("index", index);
        return "person";
    }

    @PostMapping("/people")
    public String add(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }

}
