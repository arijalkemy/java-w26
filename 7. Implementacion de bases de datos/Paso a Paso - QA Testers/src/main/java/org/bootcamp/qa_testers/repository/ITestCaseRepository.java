package org.bootcamp.qa_testers.repository;

import org.bootcamp.qa_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
