package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;


@RestController
@RequestMapping("/api/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/upload-csv")
    public String uploadCsv() {
        try {
            personService.uploadCSVData();  // No need to pass file path as parameter
            return "CSV data uploaded successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload CSV data.";
        }
    }

    @GetMapping("/getAll")
    public Iterable<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/insert")
    public Person insertPerson(@RequestBody Person person) {
        return personService.insertPerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable String id) {
        return personService.updatePerson(person, id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }

//    @GetMapping("/search")
//    public Iterable<Person> searchPeople(@RequestParam String query) {
//        return personService.searchPeople(query);
//    }
}

