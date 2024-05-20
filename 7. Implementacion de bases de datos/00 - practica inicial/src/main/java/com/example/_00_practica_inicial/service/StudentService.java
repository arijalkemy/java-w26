package com.example._00_practica_inicial.service;

import com.example._00_practica_inicial.dto.request.StudentRequestDTO;
import com.example._00_practica_inicial.dto.response.StudentResponseDTO;
import com.example._00_practica_inicial.model.Student;
import com.example._00_practica_inicial.repository.IStudentRepository;
import com.example._00_practica_inicial.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepository iStudentRepository;

    public StudentResponseDTO add(StudentRequestDTO studentRequest){
        Student student = StudentMapper.mapToEntityFromRequest(studentRequest);

        return StudentMapper.transferToResponseDto(iStudentRepository.save(student));
    }

    @Override
    public StudentResponseDTO edit(int id, String name) throws Exception {
        Student student = StudentMapper.mapToEntityFromResponse(getStudent(id));

        student.setName(name);

        return StudentMapper.transferToResponseDto(iStudentRepository.save(student));
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
        Student student = iStudentRepository.findById(id)
                .orElseThrow(Exception::new);

        return StudentMapper.transferToResponseDto(student);
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        getStudent(id);

        iStudentRepository.deleteById(id);
    }
}
