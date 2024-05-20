package org.example.templatemvc.Mapper;

import org.example.templatemvc.DTOs.Request.TestCaseRequest;
import org.example.templatemvc.DTOs.Response.TestCaseResponse;
import org.example.templatemvc.Repository.Entity.TestCase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ITestCaseMapper {

    TestCase toTestCase(TestCaseRequest testCaseResponse);
    TestCaseResponse toTestCaseResponse(TestCase testCase);


    List<TestCaseResponse> toTestCaseResponseList(List<TestCase> testCaseList);

}
