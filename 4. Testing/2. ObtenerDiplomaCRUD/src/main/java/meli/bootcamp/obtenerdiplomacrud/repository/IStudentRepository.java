package meli.bootcamp.obtenerdiplomacrud.repository;

import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
