package org.example.integradorstudentjpa.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorstudentjpa.dto.StudentRequestDTO;
import org.example.integradorstudentjpa.dto.StudentResponseDTO;
import org.example.integradorstudentjpa.dto.StudentUpdateDTO;
import org.example.integradorstudentjpa.exception.ConflictException;
import org.example.integradorstudentjpa.exception.NotFoundException;
import org.example.integradorstudentjpa.model.Student;
import org.example.integradorstudentjpa.repository.IStudentRepository;
import org.example.integradorstudentjpa.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Inyección con constructor y lombok

public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;
    private final ObjectMapper objectMapper;

    private Student studentMapper(StudentRequestDTO studentRequestDTO){
        return objectMapper.convertValue(studentRequestDTO, Student.class);
    }
    private Student studentMapper(StudentUpdateDTO studentUpdateDTO){
        return objectMapper.convertValue(studentUpdateDTO, Student.class);
    }
    private StudentResponseDTO studentResponseDTOMapper(Student student){
        return objectMapper.convertValue(student, StudentResponseDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentResponseDTO> studentResponseDTOList = new ArrayList<>();
        for (Student stu: studentList){
            studentResponseDTOList.add(studentResponseDTOMapper(stu));
        }
        return studentResponseDTOList;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDTO findStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            return studentResponseDTOMapper(studentOptional.get());
        } else {
            throw new NotFoundException("Student with ID: " + id + " doesn't exists.");
        }
    }

    @Override
    @Transactional
    public void saveStudent(StudentRequestDTO studentRequestDTO) {
        List<StudentResponseDTO> studentList = getAllStudents();
        for (StudentResponseDTO student : studentList){
            if (student.getDni().equals(studentRequestDTO.getDni())
                && student.getName().equals(studentRequestDTO.getName())
                && student.getSurname().equals(studentRequestDTO.getSurname())){
                throw new ConflictException("Student already exists.");
            }
        }
        studentRepository.save(studentMapper(studentRequestDTO));

    }

    @Override
    @Transactional
    public void updateStudent(StudentUpdateDTO studentupdateDTO) {
        findStudentById(studentupdateDTO.getId());
        studentRepository.save(studentMapper(studentupdateDTO));
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            studentRepository.deleteById(id);
        } else {
            throw new NotFoundException("Student with ID: " + id + "doesn't exists.");
        }
    }
}
