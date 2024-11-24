//package com.example.demo.service;
//
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.query.Query;
//import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
//import org.springframework.data.elasticsearch.core.query.Criteria;
//import org.springframework.data.elasticsearch.core.SearchHits;
//
//@Service
//public class SearchService {
//
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchRestTemplate;
//
//    public SearchHits<Person> search(String query) {
//        Query searchQuery = new CriteriaQuery(Criteria.where("student_name").matches(query));
//        return elasticsearchRestTemplate.search(searchQuery, Person.class);
//    }
//}
