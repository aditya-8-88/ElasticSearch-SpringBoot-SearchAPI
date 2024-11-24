package com.example.demo.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.entity.Product;

public interface ProductRepo extends ElasticsearchRepository<Product, Integer>{

}
