package com.bootcamp.JPAImplementation.service;

import com.bootcamp.JPAImplementation.dto.CalificationsOfStudentDTO;
import com.bootcamp.JPAImplementation.dto.StudentRequestDTO;
import com.bootcamp.JPAImplementation.dto.StudentResponseDTO;
import com.bootcamp.JPAImplementation.dto.StudentToUpdateRequestDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IStudentService {
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
    List<StudentResponseDTO> findAll();
    StudentResponseDTO findById(Long id);
    void delete(Long id);
    void udpate(Long id, String identification, String name, String lastName);
    void udpate(StudentToUpdateRequestDTO studentToUpdateRequestDTO);
    CalificationsOfStudentDTO getCalifications(Long studentId);
}
