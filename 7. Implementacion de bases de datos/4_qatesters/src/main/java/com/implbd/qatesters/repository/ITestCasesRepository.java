package com.implbd.qatesters.repository;

import com.implbd.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITestCasesRepository extends JpaRepository<TestCase, Long> {
}
