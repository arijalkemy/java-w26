package org.example.jpatesterqa.repository;

import org.example.jpatesterqa.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
