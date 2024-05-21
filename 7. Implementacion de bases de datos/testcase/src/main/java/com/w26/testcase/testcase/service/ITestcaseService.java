package com.w26.testcase.testcase.service;


import com.w26.testcase.testcase.dto.Testcase.GetAllTestcase;
import com.w26.testcase.testcase.dto.Testcase.GetTestcase;
import com.w26.testcase.testcase.dto.Testcase.PatchTestcase;
import com.w26.testcase.testcase.dto.Testcase.PostTestcase;
import com.w26.testcase.testcase.dto.Testcase.UpdateTestcase;

public interface ITestcaseService {
    Long           createTestcase(PostTestcase testcaseToCreate);
    GetTestcase    getTestcase(Long idTestcase);
    GetAllTestcase getAllTestcases(int page);
    Long           deleteTestCase(Long idTestcase);
    Boolean        patchTestCase(Long idTestcase, PatchTestcase testcaseToPatch);
    Boolean        updateTestCase(Long idTestcase, UpdateTestcase testcaseToPatch);
}
