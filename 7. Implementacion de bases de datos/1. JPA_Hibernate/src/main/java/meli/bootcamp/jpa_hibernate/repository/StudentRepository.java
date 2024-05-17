package meli.bootcamp.jpa_hibernate.repository;

import meli.bootcamp.jpa_hibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
