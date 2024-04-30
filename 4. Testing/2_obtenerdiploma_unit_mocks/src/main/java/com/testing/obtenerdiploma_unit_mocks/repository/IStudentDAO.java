package com.testing.obtenerdiploma_unit_mocks.repository;


import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}