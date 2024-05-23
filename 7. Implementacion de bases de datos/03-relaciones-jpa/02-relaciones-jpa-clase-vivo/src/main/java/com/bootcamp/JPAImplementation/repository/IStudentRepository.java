package com.bootcamp.JPAImplementation.repository;

import com.bootcamp.JPAImplementation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
