package com.example.qatester.repository;

import com.example.qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findAllByLocalDateAfter();
}
