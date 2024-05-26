package Ejercicio.TestCase.Service;

import Ejercicio.TestCase.Dto.TestCaseRequestDto;
import Ejercicio.TestCase.Dto.TestCaseResponseDto;
import Ejercicio.TestCase.Entity.TestCase;
import Ejercicio.TestCase.Repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private final ITestCaseRepository iTestCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseServiceImpl(ITestCaseRepository iTestCaseRepository) {
        this.iTestCaseRepository = iTestCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void createTestCase(TestCaseRequestDto testCaseRequestDto) {
        TestCase testCase = modelMapper.map(testCaseRequestDto, TestCase.class);
        iTestCaseRepository.save(testCase);
    }

    @Override
    public TestCaseResponseDto getAllTestCases(Long id) {
        Optional<TestCase> testCases = iTestCaseRepository.findById(id);
        return modelMapper.map(testCases, TestCaseResponseDto.class);
    }

    @Override
    public void updateTestCase(TestCaseRequestDto testCase, Long id) {

    }

    @Override
    public void deleteTestCase(Long id) {

    }

    @Override
    public TestCaseResponseDto getTestCaseById(Long id) {
        return null;
    }

    @Override
    public List<TestCaseResponseDto> getUpdatedTestCasesBy(LocalDate date) {
        return null;
    }
}
