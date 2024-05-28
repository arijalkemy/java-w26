package com.mercadolibre.qatesters.repository;

import com.mercadolibre.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
