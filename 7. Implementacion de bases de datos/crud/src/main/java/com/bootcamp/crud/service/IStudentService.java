package com.bootcamp.crud.service;

import com.bootcamp.crud.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
    public void saveStudent(Student s);
    public void deleteStudent(Long id);
    public Student findStudent(Long id);
}
