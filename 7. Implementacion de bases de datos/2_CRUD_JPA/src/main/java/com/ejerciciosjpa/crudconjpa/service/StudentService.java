package com.ejerciciosjpa.crudconjpa.service;

import com.ejerciciosjpa.crudconjpa.model.Student;
import com.ejerciciosjpa.crudconjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id,String newName, String newLastName) {
       Student studentToUpdate = findStudent(id);
       studentToUpdate.setName(newName);
       studentToUpdate.setLastName(newLastName);
       saveStudent(studentToUpdate);
       return studentToUpdate;
    }
}
