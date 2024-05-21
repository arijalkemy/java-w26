package com.w26.testcase.testcase.dto.Testcase;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GetAllTestcase  implements Serializable {
    private List<GetTestcase> testCases;
}
