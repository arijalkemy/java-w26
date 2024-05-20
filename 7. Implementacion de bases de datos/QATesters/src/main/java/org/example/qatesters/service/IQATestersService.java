package org.example.qatesters.service;

import org.example.qatesters.DTO.RequestQATesterDTO;

import java.time.LocalDate;
import java.util.List;

public interface IQATestersService {
    RequestQATesterDTO createQATester(RequestQATesterDTO requestQATesterDTO);
    List<RequestQATesterDTO> getAllQATesters();
    RequestQATesterDTO getQATesterById(Long id);
    RequestQATesterDTO updateQATester(Long id, RequestQATesterDTO requestQATesterDTO);
    void deleteQATester(Long id);
    List<RequestQATesterDTO> getTestCasesByStatus(LocalDate lastUpdated);
}
