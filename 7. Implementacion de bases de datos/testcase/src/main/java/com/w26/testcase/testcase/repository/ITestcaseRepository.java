package com.w26.testcase.testcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.w26.testcase.testcase.model.Testcase;

public interface ITestcaseRepository extends JpaRepository<Testcase, Long> {
    
}
