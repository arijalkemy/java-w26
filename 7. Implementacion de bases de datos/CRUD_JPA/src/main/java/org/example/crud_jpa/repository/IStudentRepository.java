package org.example.crud_jpa.repository;

import org.example.crud_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByName(String name);
}
