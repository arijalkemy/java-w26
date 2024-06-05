package org.meli.ejercicio6_p2_d2_qa_testers.repository;

import org.meli.ejercicio6_p2_d2_qa_testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query(value = "SELECT * FROM test_cases t WHERE t.last_update > :date", nativeQuery = true)
    List<TestCase> getAllTestCaseByFilter(@Param("date") LocalDate date);

}
