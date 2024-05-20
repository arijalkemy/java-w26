package org.example.templatemvc.Repository;

import org.example.templatemvc.Repository.Entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {}
