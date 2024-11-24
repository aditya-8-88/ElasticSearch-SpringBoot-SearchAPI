package com.example.demo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Person;
import com.example.demo.repo.PersonRepo;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Value("${csv.file.path}")
    private String csvFilePath;

    public Iterable<Person> getAllPeople() {
        return personRepo.findAll();
    }

    public Person getPersonById(String id) {
        return personRepo.findById(id).orElse(null);
    }

    public Person insertPerson(Person person) {
        return personRepo.save(person);
    }

    public void uploadCSVData() throws Exception {
        List<Person> people = new ArrayList<>();
        try (Reader reader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                Person person = new Person();
                person.setId(record.get("roll_no")); // Ensure "id" matches the CSV header
                person.setStudent_id(record.get("student_id"));
                person.setStudent_name(record.get("student_name"));
                person.setFirst_year_section_rollno(record.get("first_year_section_rollno"));
                person.setGroup(record.get("group"));
                person.setCollege_email_id(record.get("college_email_id"));
                people.add(person);
            }
        }

        if (!people.isEmpty()) {
            personRepo.saveAll(people);  // Save to Elasticsearch
        } else {
            System.out.println("No data found in CSV file.");
        }
    }

    public Person updatePerson(Person person, String id) {
        Optional<Person> existingPerson = personRepo.findById(id);
        if (existingPerson.isPresent()) {
            Person personToUpdate = existingPerson.get();
            personToUpdate.setStudent_id(person.getStudent_id());
            personToUpdate.setStudent_name(person.getStudent_name());
            personToUpdate.setFirst_year_section_rollno(person.getFirst_year_section_rollno());
            personToUpdate.setGroup(person.getGroup());
            personToUpdate.setCollege_email_id(person.getCollege_email_id());
            return personRepo.save(personToUpdate);
        } else {
            throw new RuntimeException("Person not found with id " + id);
        }
    }

    public void deletePerson(String id) {
        personRepo.deleteById(id);
    }

    // Optional: Search functionality
    // Uncomment and implement if needed
    /*
    public Iterable<Person> searchPeople(String query) {
        return personRepo.findByStudent_nameContainingOrGroupContaining(query, query);
    }
    */
}
