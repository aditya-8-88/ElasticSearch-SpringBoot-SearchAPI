package com.example.demo.entity;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "people")
public class Person {
	@Id
    private String id;
    private String student_id;
    private String student_name;
    private String first_year_section_rollno;
    private String group;
    private String college_email_id;
}


//roll_no,student_id,student_name,first_year_section_rollno,group,college_email_id
