package org.meli.ejercicio6_p3_d1_estudiante.service;

import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentResponseDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentToUpdateRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.entity.Student;
import org.meli.ejercicio6_p3_d1_estudiante.exception.NotFoundException;
import org.meli.ejercicio6_p3_d1_estudiante.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.meli.ejercicio6_p3_d1_estudiante.service.Iservice.IStudentService;
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
