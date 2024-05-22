package jpa.crudjpa.service;

import jpa.crudjpa.model.Student;
import jpa.crudjpa.repository.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository stuRepo;

    public StudentService(IStudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(long id) {
        Student student = stuRepo.findById(id).orElse(null);
        return student;
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


}
