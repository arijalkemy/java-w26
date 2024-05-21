package com.bootcamp.qatesters.repositories;

import com.bootcamp.qatesters.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate date);
    List<TestCase> findByDescriptionLike(String description);
    List<TestCase> findAllOrderByDescription();
}
