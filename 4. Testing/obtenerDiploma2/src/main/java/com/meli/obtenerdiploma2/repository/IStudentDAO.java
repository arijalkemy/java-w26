package com.meli.obtenerdiploma2.repository;

import com.meli.obtenerdiploma2.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}