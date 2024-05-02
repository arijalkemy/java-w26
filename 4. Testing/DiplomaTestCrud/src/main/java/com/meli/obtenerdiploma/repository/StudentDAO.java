package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentAllreadyExistException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO, IStudentUtilDAO {

    @Value("${uri}")
    private String URI;
    private Set<StudentDTO> students = new HashSet<>();

    public StudentDAO() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application-test.properties").getInputStream());
            this.URI = properties.getProperty("uri");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long save(StudentDTO stu) {
        if (existsById(stu.getId())) throw new StudentAllreadyExistException(stu.getId());

        students.add(stu);
        this.saveData();
        return stu.getId();
    }

    @Override
    public boolean delete(Long id) {
        if (!existsById(id)) return false;
        else {
            StudentDTO student = findById(id);
            return students.remove(student);
        }
    }

    @Override
    public boolean deleteAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        students.clear();
        try {
            File file = ResourceUtils.getFile(URI);
            objectMapper.writeValue(file, this.students);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return students.stream().anyMatch(student -> student.getId().equals(id));
    }

    @Override
    public StudentDTO findById(Long id) {
        return students
                .stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    private void loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(URI);
            loadedData = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.students = loadedData;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(URI);
            objectMapper.writeValue(file, this.students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }


}
