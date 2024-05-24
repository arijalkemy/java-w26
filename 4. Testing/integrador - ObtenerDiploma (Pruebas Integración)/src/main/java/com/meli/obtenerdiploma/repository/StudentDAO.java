package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO {

    private Set<StudentDTO> students;


    public StudentDAO() {
        loadData();
    }

    @Override
    public void save(StudentDTO stu) {
        boolean exists = exists(stu);
        if (!exists) {
            stu.setId((students.size() + 1L));
            students.add(stu);
        } else {
            throw new StudentNotFoundException(stu.getId());
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            StudentDTO found = this.findById(id);
            students.remove(found);
        } catch (StudentNotFoundException e) {
            throw new StudentNotFoundException(id);
        }

        return true;
    }

    public boolean exists(StudentDTO stu) {
        Optional<StudentDTO> found = students
                .stream()
                .filter(studentDTO -> studentDTO.getId().equals(stu.getId())).findFirst();
        return (found.isPresent());
    }

    @Override
    public StudentDTO findById(Long id) {
        Optional<StudentDTO> response = students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst();
        if (response.isEmpty()){
            throw new StudentNotFoundException(id);
        }
        return response.get();
    }

    private void loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.students = loadedData;
    }

}
