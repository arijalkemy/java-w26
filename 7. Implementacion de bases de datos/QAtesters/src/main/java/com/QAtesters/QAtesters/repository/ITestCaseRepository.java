package com.QAtesters.QAtesters.repository;

import com.QAtesters.QAtesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository  extends JpaRepository<TestCase, Long> {
}
