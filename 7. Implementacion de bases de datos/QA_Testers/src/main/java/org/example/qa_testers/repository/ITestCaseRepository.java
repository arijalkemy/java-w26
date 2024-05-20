package org.example.qa_testers.repository;

import org.example.qa_testers.models.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
