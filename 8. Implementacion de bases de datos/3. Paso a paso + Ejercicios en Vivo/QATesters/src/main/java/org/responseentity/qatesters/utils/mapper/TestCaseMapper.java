package org.responseentity.qatesters.utils.mapper;

import org.responseentity.qatesters.dto.TestCaseDTO;
import org.responseentity.qatesters.model.TestCase;

public class TestCaseMapper {
    public static TestCaseDTO convertEntityToDTO(TestCase entity) {
        return TestCaseDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .tested(entity.getTested())
                .passed(entity.getPassed())
                .number_of_tries(entity.getNumber_of_tries())
                .last_update(entity.getLast_update())
                .build();
    }

    public static TestCase convertDTOToEntity(TestCaseDTO dto) {
        return TestCase.builder()
                .description(dto.getDescription())
                .tested(dto.getTested())
                .passed(dto.getPassed())
                .number_of_tries(dto.getNumber_of_tries())
                .last_update(dto.getLast_update())
                .build();
    }
}
