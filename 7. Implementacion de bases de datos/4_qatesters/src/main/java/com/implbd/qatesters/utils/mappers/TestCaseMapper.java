package com.implbd.qatesters.utils.mappers;

import com.implbd.qatesters.dto.TestCaseRequestDTO;
import com.implbd.qatesters.dto.TestCaseResponseDTO;
import com.implbd.qatesters.entity.TestCase;
import com.implbd.qatesters.exception.BadRequestException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestCaseMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private TestCaseMapper() {}

    public static TestCase mapToTestCase(TestCaseRequestDTO request){
        try {
            LocalDate date = LocalDate.parse(request.getLastUpdate(), formatter);
            return TestCase.builder()
                    .description(request.getDescription())
                    .tested(request.getTested())
                    .passed(request.getPassed())
                    .numberOfTries(request.getNumberOfTries())
                    .lastUpdate(date)
                    .build();
        }catch (DateTimeException | IllegalArgumentException e) {
            throw new BadRequestException("Formato inválido " + e.getMessage());
        }
    }

    public static TestCaseResponseDTO mapToTestCaseResponseDto(TestCase testCase){
        return new TestCaseResponseDTO(
                testCase.getIdCase(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                formatter.format(testCase.getLastUpdate())
        );
    }

}
