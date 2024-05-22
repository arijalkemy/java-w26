package org.implementaciondb.ejercicio3_qatesters.repository;

import org.implementaciondb.ejercicio3_qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository <TestCase, Long> {

}
