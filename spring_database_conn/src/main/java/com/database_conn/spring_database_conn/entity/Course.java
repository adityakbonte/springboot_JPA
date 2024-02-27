package com.database_conn.spring_database_conn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    // defining the attributes
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    /// we define the foreign key in course material in onn-to-one direction, but we have to want bi-direactional for that we have to define the one-to-one , mapped by course

    @OneToOne(                       // using this mapped porperty we ,ake the bi-directional relationaship
            mappedBy = "course"        // if we not mapped then you are only able to fetch course not course material using courseMaterialTest
    )
    private CourseMaterial courseMaterial;

//    @ManyToOne(           // this and @OneToMany from the entity teacher is same , use any one of them
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private Teacher teacher;
}
