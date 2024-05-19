package com.w26.students.students.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.students.students.dto.StudentCreation;
import com.w26.students.students.dto.StudentPatch;
import com.w26.students.students.exception.InternalEntityNotFound;
import com.w26.students.students.models.Student;
import com.w26.students.students.repository.IStudentRepository;
import com.w26.students.students.util.CustomSpringBeanUtils;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    private final Pageable page = Pageable.ofSize(10); //Debería refactorizarse

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAll(int numberPage) {
        Page<Student> result = studentRepository.findAll(page.withPage(numberPage));
        if (result.isEmpty()) {
            throw new InternalEntityNotFound("Any student was fount!");
        }
        return result.toList();
    }

    @Override
    public Student get(Long id) {
        Student studentRecovery = studentRepository.getReferenceById(id);

        /**
         * La Función de abajo para conseguir la exception es muy dudosa su aplicación jajsjsj
         */
        try {
            studentRecovery.getDni();
        } catch (EntityNotFoundException exception) {
            throw new InternalEntityNotFound("The student with id " + id + " was not found.");
        }

        return studentRecovery;
    }


    @Override
    public void create(StudentCreation studentToCreate) {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.convertValue(studentToCreate, Student.class);
        studentRepository.save(student);
    }


    @Override
    public void delete(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        
        if (optional.isEmpty()) {
            throw new InternalEntityNotFound("The student with id " + id + " was not found.");
        }
        
        studentRepository.delete(optional.get());
    }


    @Override
    public void update(Long id, StudentPatch studentToPatch) {

        Optional<Student> optional = studentRepository.findById(id);
        
        validateEntity(optional, "The student with id " + id + "was not found.");

        ObjectMapper objectMapper = new ObjectMapper();
        Student source =  objectMapper.convertValue(studentToPatch, Student.class);
        Student target = optional.get();

        //BeanUtils.copyProperties(source, target, null);
        CustomSpringBeanUtils.copyNonNullProperties(source, target);
        studentRepository.save(target);
    }
    
    public <T extends Optional> void validateEntity(T optional, String message) {
        if (optional.isEmpty()) {
            throw new InternalEntityNotFound(message);
        }
    }
}
