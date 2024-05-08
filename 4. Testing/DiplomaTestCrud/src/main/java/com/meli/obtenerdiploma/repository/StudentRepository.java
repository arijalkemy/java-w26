package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class StudentRepository implements IStudentRepository {

    @Value("${uri}")
    private String URI;


        public StudentRepository() {
            Properties properties = new Properties();
            try {
                properties.load(new ClassPathResource("application-test.properties").getInputStream());
                this.URI = properties.getProperty("uri");
//                this.loadData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    @Override
    public Set<StudentDTO> findAll() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(URI);
            loadedData = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }

    @Override
    public boolean saveData(Set<StudentDTO> students) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(URI);
            objectMapper.writeValue(file, students);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
        return false;
    }

    @Override
    public boolean deleteAll(Set<StudentDTO> students) {
        return saveData(students);
    }
}
