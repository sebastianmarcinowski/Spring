package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/add")
    public String showAddPersonForm(Model model){
        model.addAttribute("person", new Person());
        return "person_form";
    }

    @PostMapping("/person/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }
}
