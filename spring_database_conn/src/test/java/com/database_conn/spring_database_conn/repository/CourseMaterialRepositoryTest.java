package com.database_conn.spring_database_conn.repository;

import com.database_conn.spring_database_conn.entity.Course;
import com.database_conn.spring_database_conn.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    // creating the method to save course
    @Test
    public void saveCourseMaterial(){

        Course course =
                Course.builder()
                        .title("DSA")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.google.com")
                        .course(course)                /// we have to pass course object here
                        .build();

        repository.save(courseMaterial);
    }
}