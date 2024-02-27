package com.database_conn.spring_database_conn.repository;

import com.database_conn.spring_database_conn.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired               //@Autowired is one of the core annotations in Spring, used for automatic dependency injection.
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("adi@gmail.com") 
                .firstName("aditya")
                .lastName("Bonte")
                .guardianName("Kishor")
                .guardianEmail("kishoe@gmail.com")
                .guardianMobile("722034344")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAll(){
        List<Student>studentList= studentRepository.findAll();
        System.out.println("student_list="+ studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student>students = studentRepository.findByFirstName("Bonte");

        System.out.println("Student details:"+students);
    }

    @Test
    public void printStudentByFirstNameChar(){
        List<Student>students = studentRepository.findByFirstNameContaining("Bo");
        System.out.println("Student contains char: "+students);
    }

    @Test
    public void printByLastName(){
        List<Student>students = studentRepository.findByLastName("Bonte");
        System.out.println("Student find by last name: "+students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("adi@gmail.com");   // for student there is unique email is condition so , we don't have to write List<>
        System.out.println("Finding student using email id uaing query: "+student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("adi@gmail.com");
        System.out.println("Finding the student using first name : "+studentFirstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student s = studentRepository.getStudentByEmailAddressNative("adi@gmail.com");
        System.out.println("find the student using email with native query :"+s);
    }

    @Test
    public void printgetStudentByEmailAddressNativeParam(){
        Student s = studentRepository.getStudentByEmailAddressNativeParam("adi@gmail.com");
        System.out.println("find the student using email with native query :"+s);
    }

    @Test
    public void  updatestudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "vaihanvi",
                "vaish@gmail.com"
        );
    }
}