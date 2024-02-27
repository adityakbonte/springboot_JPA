package com.database_conn.spring_database_conn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(
        exclude = "course"
)
public class CourseMaterial {
    // defining the Attributes
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    // this course material follows the relationship (one to one )with course because course material not consist without course
    @OneToOne(
            cascade = CascadeType.ALL,    // this is required when we are connecting 2 tables , means we are used two tables using forien key
            fetch = FetchType.LAZY     // there are two types of FetchType 1] LAZY and 2] EAGER, when we used lazy it only print course material , when we want course material and course then we have to use EAGER and for that we have to define annotation toString(  exclude="course"), when we are using LAZy
    )
    @JoinColumn(        /// this join column is use to join the two tables using forgein key, in which course id is act as a forgein key for the table coursematerial
            name = "course_id",         // soo this act as attribute in course material table
            referencedColumnName = "courseId"      // and this is the foreign key to joinn two table
    )
    private Course course;
}
