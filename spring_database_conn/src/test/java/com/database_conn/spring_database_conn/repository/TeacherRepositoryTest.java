package com.database_conn.spring_database_conn.repository;

import com.database_conn.spring_database_conn.entity.Course;
import com.database_conn.spring_database_conn.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDBA =
                Course.builder()
                        .title("DBA")
                        .credit(5)
                        .build();

        Course courseJAVA =
                Course.builder()
                        .title("JAVA")
                        .credit(3)
                        .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Milind")
                        .lastName("Kamble")
                        .courses(List.of(courseDBA,courseJAVA))   // so this teacher teaches 2 courses
                        .build();

        teacherRepository.save(teacher);
    }
}