package com.bootcamp.JPAImplementation.repository;

import com.bootcamp.JPAImplementation.entity.StudentCourseCalification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentCourseCalificationRepository extends JpaRepository<StudentCourseCalification,
        Long> {
}
