package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IStudentDAO {
    Long save(StudentDTO stu);
    boolean delete(Long id);
    boolean existsById(Long id);
    StudentDTO findById(Long id);
}