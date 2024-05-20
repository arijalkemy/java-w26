package co.com.mercadolibre.qatesters.service.impl;

import co.com.mercadolibre.qatesters.dto.TestCaseDTO;
import co.com.mercadolibre.qatesters.entity.TestCase;
import co.com.mercadolibre.qatesters.exception.NotFoundException;
import co.com.mercadolibre.qatesters.repository.ITestCaseRepository;
import co.com.mercadolibre.qatesters.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    private final ModelMapper modelMapper;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseDTO create(TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> findAll() {
        return testCaseRepository.findAll().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }

    @Override
    public Page<TestCaseDTO> findAll(Pageable page) {
        return testCaseRepository.findAll(page)
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class));
    }

    @Override
    public TestCaseDTO findById(Long id) {
        if (testCaseRepository.findById(id).isEmpty()) {
            throw new NotFoundException("The test case does not exist");
        }
        return testCaseRepository.findById(id)
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .orElse(null);
    }

    @Override
    public TestCaseDTO update(TestCaseDTO testCaseDTO, Long id) {
        if (!testCaseRepository.existsById(id)) {
            throw new NotFoundException("The test case does not exist");
        }
        testCaseDTO.setIdCase(id);
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCaseRepository.save(testCase);
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public Boolean delete(Long id) {
        if (testCaseRepository.existsById(id)) {
            testCaseRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException("The test case does not exist");
    }

    @Override
    public List<TestCaseDTO> findByLastUpdate(LocalDate lastUpdate) {
        Optional<List<TestCase>> testCases = testCaseRepository.findByLastUpdate(lastUpdate);
        if (testCases.isEmpty()) {
            throw new NotFoundException("There are no test cases with the specified date");
        }
        return testCases.get().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }
}
