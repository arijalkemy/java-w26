package com.example._00_practica_inicial.service;

import com.example._00_practica_inicial.dto.request.StudentRequestDTO;
import com.example._00_practica_inicial.dto.response.StudentResponseDTO;
import com.example._00_practica_inicial.model.Student;
import com.example._00_practica_inicial.repository.IStudentRepository;
import com.example._00_practica_inicial.utils.StudentMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository iStudentRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public StudentResponseDTO add(StudentRequestDTO studentRequest){

        Student student = mapper.convertValue(studentRequest, Student.class);

        return mapper.convertValue(iStudentRepository.save(student), StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO edit(int id, String name) throws Exception {
        Student student = iStudentRepository.findById(id)
                .orElse(null);
        if(student == null)
            throw new Exception("No existe el estudiante");

        student.setName(name);

        return mapper.convertValue(iStudentRepository.save(student), StudentResponseDTO.class);
    }

    @Override
    public List<StudentResponseDTO> getStudents() {
        List<StudentResponseDTO> studentsResponse = new ArrayList<>();

        for (Student student : iStudentRepository.findAll()){
            studentsResponse.add(StudentMapper.transferToResponseDto(student));
        }

        return studentsResponse;
    }

    @Override
    public StudentResponseDTO getStudent(int id) throws Exception {
        StudentResponseDTO studentResponse = StudentMapper.transferToResponseDto(iStudentRepository.findById(id)
                                                                                    .orElse(null));
        if(studentResponse == null)
            throw new Exception("Error");

        return studentResponse;
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        getStudent(id);

        iStudentRepository.deleteById(id);
    }

}
