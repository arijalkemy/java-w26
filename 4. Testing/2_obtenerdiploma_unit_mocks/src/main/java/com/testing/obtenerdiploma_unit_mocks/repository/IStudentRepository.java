package com.testing.obtenerdiploma_unit_mocks.repository;

import com.testing.obtenerdiploma_unit_mocks.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
