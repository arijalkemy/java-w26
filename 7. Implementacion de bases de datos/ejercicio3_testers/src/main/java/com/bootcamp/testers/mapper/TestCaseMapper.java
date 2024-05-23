package com.bootcamp.testers.mapper;

import com.bootcamp.testers.dto.TestCaseDTO;
import com.bootcamp.testers.model.TestCase;
import org.modelmapper.ModelMapper;

import java.util.List;

public class TestCaseMapper {

    public static TestCaseDTO testCaseToTestCaseDTO (TestCase testCase){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    public static TestCase testCaseDTOToTestCase (TestCaseDTO testCaseDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(testCaseDTO, TestCase.class);
    }

    public static List<TestCaseDTO> testCaseListToTestCaseDTOList (List<TestCase> testCaseList){
        return testCaseList.stream()
                .map(TestCaseMapper::testCaseToTestCaseDTO)
                .toList();
    }

}
