package com.ejerciciocrud.qatester.repository;

import com.ejerciciocrud.qatester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
