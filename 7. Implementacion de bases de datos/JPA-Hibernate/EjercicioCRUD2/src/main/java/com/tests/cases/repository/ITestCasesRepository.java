package com.tests.cases.repository;

import com.tests.cases.entity.TestCases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCasesRepository extends JpaRepository<TestCases, Long> {
}
