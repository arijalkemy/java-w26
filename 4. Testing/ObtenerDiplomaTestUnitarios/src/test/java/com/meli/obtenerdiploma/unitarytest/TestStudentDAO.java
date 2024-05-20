package com.meli.obtenerdiploma.unitarytest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;

import java.util.HashSet;
import java.util.Set;

public class TestStudentDAO implements IStudentDAO {

    private Set<StudentDTO> students = new HashSet<>();

    @Override
    public void save(StudentDTO stu) {
        students.add(stu);
    }

    @Override
    public boolean delete(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public boolean exists(StudentDTO stu) {
        return students.contains(stu);
    }

    @Override
    public StudentDTO findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}