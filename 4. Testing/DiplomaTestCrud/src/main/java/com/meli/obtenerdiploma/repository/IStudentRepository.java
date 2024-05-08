package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();
    boolean saveData(Set<StudentDTO> students);
    boolean deleteAll(Set<StudentDTO> students);
}
