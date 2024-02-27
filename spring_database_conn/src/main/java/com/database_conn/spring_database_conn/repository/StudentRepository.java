package com.database_conn.spring_database_conn.repository;


import com.database_conn.spring_database_conn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Parameter;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long>{            // we are extending the with available repository
    // we have to define all custom method here
    public List<Student>findByFirstName(String fName);    // only have to define method

    public List<Student>findByFirstNameContaining(String name);

    public List<Student>findByLastName(String lastName);


    // JPQL (java persistance query language)       is based on the class on entity that your created not on table , because of this we write from Student s , not from tbl_student.
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);


    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // now use Native sql query
    @Query(          // this is native query, so in which we have to pass all column names same as the column names deifne in database tbl_student
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    // below is also native query only differance is that it take the parameter insted ?1"
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",     // here wehave to pas the name of param using :emailId colon(:) is imp
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);   // here you have to define @Param only


    /// till now we are done for fetching the data now below use for updating and deleting the data
    @Modifying    // this annotation is required to update delete the data in database
    @Transactional  // this annotation comlete this porcess by making the changes and commit in the database like transaction
    @Query(
            value = "update tbl_student set first_name=?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);
}
