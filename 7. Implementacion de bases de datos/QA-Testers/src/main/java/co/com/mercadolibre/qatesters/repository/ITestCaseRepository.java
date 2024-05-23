package co.com.mercadolibre.qatesters.repository;

import co.com.mercadolibre.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM test_case WHERE last_update >= ?1")
    List<TestCase> findByLastUpdate(LocalDate lastUpdate);
}
