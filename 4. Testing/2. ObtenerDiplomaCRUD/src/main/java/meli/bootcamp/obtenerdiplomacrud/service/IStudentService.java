package meli.bootcamp.obtenerdiplomacrud.service;

import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;

import java.util.Set;

public interface IStudentService {
    void create(StudentDTO stu);
    StudentDTO read(Long id);
    void update(StudentDTO stu);
    void delete(Long id);
    Set<StudentDTO> getAll();
}
