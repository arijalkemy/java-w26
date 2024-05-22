package org.implementaciondb.ejemplo3.service;

import org.implementaciondb.ejemplo3.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudents();
    void saveStudent(Student stu);
    void deleteStudent(long id);
    Student findStudent(long id);

}
