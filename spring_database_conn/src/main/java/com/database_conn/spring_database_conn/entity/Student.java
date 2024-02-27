package com.database_conn.spring_database_conn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity                //This annotation marks the class as a JPA entity, meaning it will be mapped to a database table.
@Data                   //@Data: This is a Lombok annotation that automatically generates boilerplate code such as getters, setters, toString(), equals(), and hashCode() methods.
@AllArgsConstructor      /// all constructor, toString method , getter setter all done with this.
@NoArgsConstructor       //Lombok annotation that generates a no-argument constructor.
@Builder              /// Lombok annotation used to automatically generate a builder pattern for the class. This provides a convenient way to construct instances of the class, especially when dealing with multiple optional parameters.
                      //This builder pattern can be especially useful when dealing with classes with many optional parameters or when you want to make the code more readable and concise.
@Table(                          /// this is used to change the table.
        name="tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )

)
public class Student {
    @Id     // this defines the StudentId is primary key for the table
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(                      // we can provide these types of annotation for each and every field
            name = "email_address",
            nullable = false          /// means everytime we should getting this value, not empty field we get unique email
    )
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;



}
