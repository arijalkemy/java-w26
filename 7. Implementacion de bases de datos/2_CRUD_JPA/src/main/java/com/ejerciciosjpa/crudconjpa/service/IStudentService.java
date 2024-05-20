package com.ejerciciosjpa.crudconjpa.service;

import com.ejerciciosjpa.crudconjpa.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student student);
    public void deleteStudent(Long id);
    public Student updateStudent(Long id,String newName,String newLastName);
    public Student findStudent(Long id);
}
