package org.example.crud_jpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.crud_jpa.dto.StudentRequestDTO;
import org.example.crud_jpa.dto.StudentResponseDTO;
import org.example.crud_jpa.exceptions.NotFoundException;
import org.example.crud_jpa.model.Student;
import org.example.crud_jpa.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.mapper = new ModelMapper();
    }

    private final ModelMapper mapper;
    private final IStudentRepository studentRepository;


    @Override
    @Transactional (readOnly = true)
    public List<StudentResponseDTO> getStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList.stream().map(this::convert).toList();
    }

    @Override
    @Transactional
    public StudentResponseDTO saveStudent(StudentRequestDTO student) {
        Student newStudent = convert(student);
        studentRepository.save(newStudent);
        return convert(newStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDTO findStudent(Long id) {
        return convert(studentRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDTO findStudent(String name) {
        return convert(studentRepository.findStudentByName(name).orElse(null));
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, String newName,String newLastName) throws NotFoundException {
        Student student= studentRepository.findById(id).orElseThrow(()-> new NotFoundException("No se encontró un estudiante con el Id proporcionado"));
        if(!newName.isBlank()||!newName.isEmpty()){
            student.setName(newName);
        }
        if (!newLastName.isBlank()|| !newLastName.isEmpty()){
            student.setLastname(newLastName);
        }
        studentRepository.save(student);
        return convert(student);
    }

    private StudentResponseDTO convert(Student student){
        return mapper.map(student, StudentResponseDTO.class);
    }
    private Student convert(StudentRequestDTO student){
        return mapper.map(student,Student.class);
    }
}
