package bootcamp.bendezujonathan.testcases.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.testcases.model.TestCase;

@Repository
public interface TestCaseRepository  extends JpaRepository<TestCase, Long> {
    
}
