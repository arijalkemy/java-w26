package org.bootcamp.qa_testers.service;

import org.bootcamp.qa_testers.dto.ResponseTestCaseDTO;
import org.bootcamp.qa_testers.dto.TestCaseDTO;
import org.bootcamp.qa_testers.model.TestCase;
import org.bootcamp.qa_testers.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    @Autowired
    private ITestCaseRepository testCaseRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseTestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        return modelMapper.map(testCaseRepository.save(testCase), ResponseTestCaseDTO.class);
    }

    @Override
    public List<ResponseTestCaseDTO> getTestCases(LocalDate lastUpdate) {
        if(lastUpdate != null)
            return List.of(modelMapper.map(
                    testCaseRepository.findAll().stream()
                            .filter(testCase -> testCase.getLastUpdate().isAfter(lastUpdate))
                            .toArray(TestCase[]::new)
                    , ResponseTestCaseDTO[].class));

        return List.of(modelMapper.map(testCaseRepository.findAll(), ResponseTestCaseDTO[].class));
    }

    @Override
    public ResponseTestCaseDTO getTestCaseById(Long idCase) {
        return modelMapper.map(testCaseRepository.findById(idCase), ResponseTestCaseDTO.class);
    }

    @Override
    public ResponseTestCaseDTO updateTestCase(TestCaseDTO testCaseDTO, Long idCase) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        testCase.setIdCase(idCase);

        return modelMapper.map(testCaseRepository.save(testCase), ResponseTestCaseDTO.class);
    }

    @Override
    public ResponseTestCaseDTO deleteTestCase(Long idCase) {
        ResponseTestCaseDTO responseTestCaseDTO = modelMapper.map(testCaseRepository.findById(idCase), ResponseTestCaseDTO.class);
        testCaseRepository.deleteById(idCase);
        return responseTestCaseDTO;
    }
}
