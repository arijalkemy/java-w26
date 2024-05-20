package com.implbd.crudStudentsJPA.service;

import com.implbd.crudStudentsJPA.dto.StudentRequestDTO;
import com.implbd.crudStudentsJPA.dto.StudentResponseDTO;
import com.implbd.crudStudentsJPA.entity.Student;
import com.implbd.crudStudentsJPA.exception.NotFoundException;
import com.implbd.crudStudentsJPA.repository.IStudentRepository;
import com.implbd.crudStudentsJPA.utils.mappers.StudentMappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> getStudents() {
        return this.studentRepository.findAll()
                .stream().map(StudentMappers::studentToStudentResponseDTO)
                .toList();
    }

    @Override
    @Transactional()
    public void saveStudent(StudentRequestDTO studentDTO) {
        Student student = StudentMappers.studentRequestDTOToStudent(studentDTO);
        this.studentRepository.save(student);
    }

    @Override
    @Transactional()
    public void deleteStudent(Long id) {
        this.findById(id);
        this.studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDTO findStudentById(Long id) {
        Student student = this.findById(id);
        return StudentMappers.studentToStudentResponseDTO(student);
    }

    @Override
    @Transactional
    public StudentResponseDTO updateStudent(Long id, String newName, String newLastname) {
        Student student = this.findById(id);
        student.setName(newName);
        student.setLastName(newLastname);
        this.studentRepository.save(student);
        return StudentMappers.studentToStudentResponseDTO(student);
    }

    private Student findById(Long id) {
        return this.studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found"));
    }
}
