package meli.bootcamp.obtenerdiplomacrud.repository;


import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}