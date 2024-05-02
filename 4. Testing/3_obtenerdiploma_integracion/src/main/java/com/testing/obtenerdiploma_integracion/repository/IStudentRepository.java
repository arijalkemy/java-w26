package com.testing.obtenerdiploma_integracion.repository;


import com.testing.obtenerdiploma_integracion.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
