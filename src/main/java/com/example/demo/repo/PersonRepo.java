package com.example.demo.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.demo.entity.Person;

public interface PersonRepo extends ElasticsearchRepository<Person, String> {
    Iterable<Person> findByStudentNameContainingOrGroupContaining(String studentName, String group);
}