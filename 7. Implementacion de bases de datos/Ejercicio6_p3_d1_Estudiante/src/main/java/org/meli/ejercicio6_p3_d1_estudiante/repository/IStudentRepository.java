package org.meli.ejercicio6_p3_d1_estudiante.repository;

import org.meli.ejercicio6_p3_d1_estudiante.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
