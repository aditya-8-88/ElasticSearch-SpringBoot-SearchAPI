package com.example.demo.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product")
public class Product {
	private int id;
	private String name;
	private String info;
}
