package com.bootcamp.course.service.impl;

import com.bootcamp.course.dto.StudentDTO;
import com.bootcamp.course.entity.Student;
import com.bootcamp.course.exception.NotFoundException;
import com.bootcamp.course.mapper.StudentMapper;
import com.bootcamp.course.repository.IStudentRepository;
import com.bootcamp.course.service.IStudentService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final String NOT_FOUND_MESSAGE = "No se encontró el alumno solicitado";

    @Override
    @Transactional
    public StudentDTO save(StudentDTO studentRequestDTO) {
        return StudentMapper.studentToStudentDTO(
                studentRepository.save(StudentMapper.studentDTOToStudent(studentRequestDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> findAll() {
        return StudentMapper.studentListToStudentDTOList(studentRepository.findAll());
    }

    @Override
    public StudentDTO findById(Long id) {
        return StudentMapper.studentToStudentDTO(studentRepository.findById(id).orElseThrow(
                () -> new NotFoundException(NOT_FOUND_MESSAGE)));
    }

    @Override
    @Transactional
    public StudentDTO update(Long id, String identification, String name, String lastName) {
        Student student = StudentMapper.studentDTOToStudent(findById(id));
        student.setIdentification(identification);
        student.setName(name);
        student.setLastName(lastName);
        return StudentMapper.studentToStudentDTO(studentRepository.save(student));
    }

    @Override
    @Transactional
    public StudentDTO update(StudentDTO studentDTO) {
        validate(studentDTO.getId());
        return StudentMapper.studentToStudentDTO(
                studentRepository.save(StudentMapper.studentDTOToStudent(studentDTO)));
    }

    @Override
    public StudentDTO findAverageStudent(Long studentId) {
        StudentDTO studentDTO = findById(studentId);
        // Se setea el promedio en el DTO
        if (studentDTO.getNote1() == null || studentDTO.getNote2() == null) {
            studentDTO.setAverage(0.0);
        } else {
            studentDTO.setAverage((studentDTO.getNote1() + studentDTO.getNote2()) / 2);
        }
        return studentDTO;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validate(id);
        studentRepository.deleteById(id);
    }

    private void validate(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

}
