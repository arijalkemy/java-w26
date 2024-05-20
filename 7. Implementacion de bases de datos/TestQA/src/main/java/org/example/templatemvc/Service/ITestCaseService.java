package org.example.templatemvc.Service;

import org.example.templatemvc.DTOs.Request.TestCaseRequest;
import org.example.templatemvc.DTOs.Response.TestCaseResponse;

import java.util.List;

public interface ITestCaseService {
    TestCaseResponse createTestCase(TestCaseRequest testCaseRequest);

    TestCaseResponse updateTestCase(Long id, TestCaseRequest testCaseRequest);


    void deleteTestCase(Long id);

    List<TestCaseResponse> getAllTestCases();

    TestCaseResponse getTestCaseById(Long id);

}
