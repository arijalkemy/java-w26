package org.responseentity.qatesters.repository;

import org.responseentity.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
