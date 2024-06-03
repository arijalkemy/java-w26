package com.meli.implementacionjpa.repository;

import com.meli.implementacionjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRespository extends JpaRepository<Student, Long> {
}
