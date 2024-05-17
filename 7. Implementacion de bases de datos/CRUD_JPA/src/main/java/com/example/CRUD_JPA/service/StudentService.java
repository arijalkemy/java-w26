package com.example.CRUD_JPA.service;

import com.example.CRUD_JPA.model.Student;
import com.example.CRUD_JPA.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepository iStudentRepository;

    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = iStudentRepository.findAll();
        return studentList;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        iStudentRepository.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        iStudentRepository.deleteById(id);

    }

    @Override
    @Transactional (readOnly = true)
    public Student findStudent(long id) {
        Student stu=iStudentRepository.findById(id).orElse(null);
        return stu;
    }
}
