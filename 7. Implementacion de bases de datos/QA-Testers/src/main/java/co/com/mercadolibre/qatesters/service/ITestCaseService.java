package co.com.mercadolibre.qatesters.service;

import co.com.mercadolibre.qatesters.dto.TestCaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseDTO create(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> findAll();
    Page<TestCaseDTO> findAll(Pageable page);
    TestCaseDTO findById(Long id);
    TestCaseDTO update(TestCaseDTO testCaseDTO, Long id);
    Boolean delete(Long id);
    List<TestCaseDTO> findByLastUpdate(LocalDate lastUpdate);
}
