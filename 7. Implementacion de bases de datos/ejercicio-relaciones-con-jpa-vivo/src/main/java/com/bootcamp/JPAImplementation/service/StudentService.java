package com.bootcamp.JPAImplementation.service;

import com.bootcamp.JPAImplementation.dto.*;
import com.bootcamp.JPAImplementation.entity.Student;
import com.bootcamp.JPAImplementation.entity.StudentCourseCalification;
import com.bootcamp.JPAImplementation.exception.NotFoundException;
import com.bootcamp.JPAImplementation.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    public StudentService(IStudentRepository studentRepository, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    private final String NOT_FOUND_MESSAGE = "No se encontró el alumno solicitado";

    @Override
    @Transactional
    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.save(mapToEntity(studentRequestDTO));
        return mapToDTO(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDTO findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NOT_FOUND_MESSAGE)
        );
        return mapToDTO(student);
    }

    @Override
    @Transactional
    public void udpate(Long id, String identification, String name, String lastName) {
        Student student = objectMapper.convertValue(findById(id), Student.class);
        student.setIdentification(identification);
        student.setName(name);
        student.setLastName(lastName);

        //studentRepository.save(student);
        /*
        Student studentToUpdate = new Student(identification, name, lastName);
         studentToUpdate.setId(student.getId());
        studentRepository.save(studentToUpdate);*/
    }

    @Override
    @Transactional
    public void udpate(StudentToUpdateRequestDTO studentToUpdateRequestDTO) {
        findById(studentToUpdateRequestDTO.getId());
        studentRepository.save(mapToEntity(studentToUpdateRequestDTO));
    }

    @Override
    public CalificationsOfStudentDTO getCalifications(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            return null;
        }

        List<StudentCourseCalification> studentCourseCalifications = student.getStudentCourseCalifications();

        Double calificationTotal = studentCourseCalifications
                .stream().mapToDouble(c -> c.getCalification1() + c.getCalification2())
                .sum();

        Double average = calificationTotal / (studentCourseCalifications.size() * 2);

        CalificationsOfStudentDTO response = new CalificationsOfStudentDTO();

        response.setAverage(average);
        response.setCalificationCourseDTOS(
                studentCourseCalifications.stream().map(
                        c -> new CalificationCourseDTO(
                                c.getCourse().getId(),
                                c.getCalification1(),
                                c.getCalification2()
                        )
                ).toList()
        );

        return response;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        studentRepository.deleteById(id);
    }

    private Student mapToEntity(StudentRequestDTO studentRequestDTO) {
        return objectMapper.convertValue(studentRequestDTO, Student.class);
    }

    private StudentResponseDTO mapToDTO(Student student) {
        return objectMapper.convertValue(student, StudentResponseDTO.class);
    }

    private Student mapToEntity(StudentToUpdateRequestDTO studentToUpdateRequestDTO) {
        return objectMapper.convertValue(studentToUpdateRequestDTO, Student.class);
    }


}
