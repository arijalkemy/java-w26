package com.ejerciciocrud.qatester.service.implementation;

import com.ejerciciocrud.qatester.dto.request.MessageDTO;
import com.ejerciciocrud.qatester.dto.request.TestCaseRequestDTO;
import com.ejerciciocrud.qatester.dto.response.TestCaseResponseDTO;
import com.ejerciciocrud.qatester.entity.TestCase;
import com.ejerciciocrud.qatester.exception.entity.NotFoundException;
import com.ejerciciocrud.qatester.repository.ITestCaseRepository;
import com.ejerciciocrud.qatester.service.ITestCaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepo;
    private final ObjectMapper mapper = new ObjectMapper();
    private final MessageDTO messageDTO = new MessageDTO();

    @Override
    @Transactional
    public MessageDTO addTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = mapper.convertValue(testCaseRequestDTO, TestCase.class);
        testCaseRepo.save(testCase);
        this.messageDTO.setMessage("TestCase saved successfully with id: " + testCase.getIdCase());
        return this.messageDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseDTO> showAllTests() {
        List<TestCaseResponseDTO> listTest = testCaseRepo.findAll()
                                .stream()
                                .map(test -> mapper.convertValue(test, TestCaseResponseDTO.class))
                                .collect(Collectors.toList());
        return listTest;
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResponseDTO showTestById(Long id) {
        TestCase testCase = findById(id);
        TestCaseResponseDTO testCaseResponseDTO = mapper.convertValue(testCase, TestCaseResponseDTO.class);
        return testCaseResponseDTO;
    }

    @Override
    @Transactional
    public TestCaseResponseDTO updateTestById(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = findById(id);

        testCase.setDescription(testCaseRequestDTO.getDescription());
        testCase.setTested(testCaseRequestDTO.getTested());
        testCase.setPassed(testCaseRequestDTO.getPassed());
        testCase.setNumberOfTries(testCaseRequestDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseRequestDTO.getLastUpdate());
        testCaseRepo.save(testCase);

        return mapper.convertValue(testCase, TestCaseResponseDTO.class);
    }

    @Override
    @Transactional
    public MessageDTO removeTestCase(Long id) {
        findById(id);
        testCaseRepo.deleteById(id);
        this.messageDTO.setMessage("Test case removed successfully with id: " + id);
        return this.messageDTO;
    }

    @Override
    public List<TestCaseResponseDTO> showTestAfterDate(LocalDate date) {
        List<TestCaseResponseDTO> listTest = testCaseRepo.findAll()
                .stream()
                .map(test -> mapper.convertValue(test, TestCaseResponseDTO.class))
                .collect(Collectors.toList());

        return listTest.stream().filter(test -> (test.getLastUpdate().isAfter(date))).toList();
    }


    private TestCase findById(Long id){
        return testCaseRepo.findById(id).orElseThrow(() -> new NotFoundException("Non existent id."));
    }
}
