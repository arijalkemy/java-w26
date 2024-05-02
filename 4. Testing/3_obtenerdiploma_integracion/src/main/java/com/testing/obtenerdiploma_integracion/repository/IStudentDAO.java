package com.testing.obtenerdiploma_integracion.repository;


import com.testing.obtenerdiploma_integracion.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}