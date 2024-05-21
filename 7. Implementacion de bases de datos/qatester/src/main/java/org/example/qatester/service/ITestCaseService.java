package org.example.qatester.service;

import org.example.qatester.dto.TestCaseDTOReq;
import org.example.qatester.dto.TestCaseDTORes;
import java.util.List;

public interface ITestCaseService {
    TestCaseDTORes create(TestCaseDTOReq testDTO);
    TestCaseDTORes update(Long id, TestCaseDTOReq testDTO);
    List<TestCaseDTORes> findAll();
    TestCaseDTORes findById(Long id);
    TestCaseDTORes delete(Long id);
    List<TestCaseDTORes> filterByDate(String date);
}
