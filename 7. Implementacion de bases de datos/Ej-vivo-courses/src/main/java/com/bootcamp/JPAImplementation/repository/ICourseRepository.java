package com.bootcamp.JPAImplementation.repository;

import com.bootcamp.JPAImplementation.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
