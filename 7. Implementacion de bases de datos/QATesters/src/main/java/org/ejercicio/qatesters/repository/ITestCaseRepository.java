package org.ejercicio.qatesters.repository;

import org.ejercicio.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
