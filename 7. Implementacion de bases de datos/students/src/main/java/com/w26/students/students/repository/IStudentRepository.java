package com.w26.students.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.w26.students.students.models.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
