package com.ejerciciosjpa.crudconjpa.repository;

import com.ejerciciosjpa.crudconjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
