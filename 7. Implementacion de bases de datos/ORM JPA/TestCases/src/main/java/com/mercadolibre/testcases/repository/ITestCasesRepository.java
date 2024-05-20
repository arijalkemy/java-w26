package com.mercadolibre.testcases.repository;

import com.mercadolibre.testcases.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCasesRepository extends JpaRepository<TestCase, Long> {
}
