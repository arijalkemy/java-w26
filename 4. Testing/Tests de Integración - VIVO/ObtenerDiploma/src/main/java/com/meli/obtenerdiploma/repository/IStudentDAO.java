package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    void update(StudentDTO stu);
    boolean delete(Long id);
    StudentDTO findById(Long id);
    int count();
    
    boolean exists(String nombre);    
    boolean exists(Long id);
}