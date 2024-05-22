package com.bootcamp.JPAImplementation.repository;

import com.bootcamp.JPAImplementation.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentCourseRepository extends JpaRepository<StudentCourse, Long> {

}
