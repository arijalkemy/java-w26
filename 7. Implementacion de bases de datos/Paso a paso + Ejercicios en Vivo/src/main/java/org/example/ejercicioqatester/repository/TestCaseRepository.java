package org.example.ejercicioqatester.repository;

import org.example.ejercicioqatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long>{
}
