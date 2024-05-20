package com.example.testcase.repository;

import com.example.testcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestRepository extends JpaRepository<TestCase, Long> {
    //List<TestCase> findByLastUpdateAfter(LocalDate lastUpdate);
}
