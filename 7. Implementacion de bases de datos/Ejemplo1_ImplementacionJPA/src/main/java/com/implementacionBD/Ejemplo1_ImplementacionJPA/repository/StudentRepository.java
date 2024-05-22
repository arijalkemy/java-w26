package com.implementacionBD.Ejemplo1_ImplementacionJPA.repository;

import com.implementacionBD.Ejemplo1_ImplementacionJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
}
