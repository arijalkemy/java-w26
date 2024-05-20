package org.example.testers.service;

import org.example.testers.dto.TestCaseDTOReq;
import org.example.testers.dto.TestCaseDTORes;

import java.util.List;

public interface ITestCaseService {
    TestCaseDTORes create(TestCaseDTOReq testDTO);
    TestCaseDTORes update(Long id, TestCaseDTOReq testDTO);
    List<TestCaseDTORes> findAll();
    TestCaseDTORes findById(Long id);
    TestCaseDTORes delete(Long id);
    List<TestCaseDTORes> filterByDate(String date);
}
