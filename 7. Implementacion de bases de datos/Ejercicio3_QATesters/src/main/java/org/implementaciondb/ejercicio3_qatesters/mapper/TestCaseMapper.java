package org.implementaciondb.ejercicio3_qatesters.mapper;

import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseRequest;
import org.implementaciondb.ejercicio3_qatesters.dto.TestCaseResponse;
import org.implementaciondb.ejercicio3_qatesters.entity.TestCase;

public class TestCaseMapper {

    public static TestCase mapToTestCase(TestCaseRequest testCaseRequest) {
        return TestCase.builder()
                .description(testCaseRequest.getDescription())
                .tested(testCaseRequest.getTested())
                .passed(testCaseRequest.getPassed())
                .numberOfTries(testCaseRequest.getNumberOfTries())
                .lastUpdate(null)
                .build();
    }

    public static TestCaseResponse mapToTestCaseDto(TestCase testCase) {
        return TestCaseResponse.builder()
                .idCase(testCase.getIdCase())
                .description(testCase.getDescription())
                .tested(testCase.getTested())
                .passed(testCase.getPassed())
                .numberOfTries(testCase.getNumberOfTries())
                .lastUpdate(testCase.getLastUpdate())
                .build();
    }

}
