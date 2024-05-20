package org.ggomezr.qatesters.domain.repository;

import org.ggomezr.qatesters.domain.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query("SELECT tc FROM TestCase tc WHERE tc.last_update > :date")
    List<TestCase> findTestCaseByLast_updateAfter(LocalDate date);
}
