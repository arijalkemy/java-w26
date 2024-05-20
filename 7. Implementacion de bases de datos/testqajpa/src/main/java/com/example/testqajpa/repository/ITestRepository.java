package com.example.testqajpa.repository;

import com.example.testqajpa.model.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<Testcase, Long>
{
}
