package com.database_conn.spring_database_conn.repository;

import com.database_conn.spring_database_conn.entity.Course;
import org.hibernate.Remove;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
