package com.database_conn.spring_database_conn.repository;

import com.database_conn.spring_database_conn.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course>course=
                courseRepository.findAll();

        System.out.println("All courses: "+course);
    }
}