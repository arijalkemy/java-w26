package org.implementaciondb.ejemplo3.service;

import org.implementaciondb.ejemplo3.model.Student;
import org.implementaciondb.ejemplo3.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository stuRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return stuRepo.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        return stuRepo.findById(id).orElse(null);
    }
}
