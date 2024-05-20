package com.implbd.crudStudentsJPA.service;

import com.implbd.crudStudentsJPA.dto.StudentRequestDTO;
import com.implbd.crudStudentsJPA.dto.StudentResponseDTO;
import com.implbd.crudStudentsJPA.entity.Student;
import com.implbd.crudStudentsJPA.repository.IStudentRepository;
import com.implbd.crudStudentsJPA.utils.mappers.StudentMappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        this.studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDTO findStudentById(Long id) {
        return this.studentRepository.findById(id)
                .map(StudentMappers::studentToStudentResponseDTO)
                .orElse(null);
    }

    @Override
    @Transactional
    public StudentResponseDTO updateStudent(Long id, String newName, String newLastname) {
        Optional<Student> optionalStudent = this.studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(newName);
            student.setLastName(newLastname);
            this.studentRepository.save(student);
            return StudentMappers.studentToStudentResponseDTO(student);
        }
        return null;
    }
}
