package com.meli.obtenerdiploma2.repository;

import com.meli.obtenerdiploma2.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
