package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.GenerateStudentsTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Profile("test")
@Repository
public class StudentTestRepository implements IStudentRepository{

    @Override
    public Set<StudentDTO> findAll() {
        return GenerateStudentsTest.generateStudents();
    }
}
