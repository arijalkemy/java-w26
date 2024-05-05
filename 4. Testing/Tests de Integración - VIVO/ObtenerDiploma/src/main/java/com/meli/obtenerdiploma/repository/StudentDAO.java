package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentAlreadyExists;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;

import lombok.extern.java.Log;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Log
@Repository
public class StudentDAO implements IStudentDAO {

    private String SCOPE;

    private Set<StudentDTO> students;


    public StudentDAO() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(StudentDTO stu) {
        log.info("Desde STUDENT DAO:" + students.toString());
        if (exists(stu.getStudentName())) {
            throw new StudentAlreadyExists("El estudiante con el nombre " + stu.getStudentName()+ " ya existe");
        }
        stu.setId((this.students.size() + 1L));
        students.add(stu);
        this.saveData();
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;

        try {
            StudentDTO found = this.findById(id);

            students.remove(found);
            ret  = true;
            this.saveData();

        } catch (StudentNotFoundException e) {}

        return ret;
    }

    public boolean exists(String nombre) {
       boolean ret = false;

       for (StudentDTO studentDTO : students) {
        if (studentDTO.getStudentName().equals(nombre)) {
            return true;
        }
       }

       return ret;
    }

    public boolean exists(Long id) {
       boolean ret = false;

       for (StudentDTO studentDTO : students) {
        if (studentDTO.getId().equals(id)) {
            return true;
        }
       }

       return ret;
    }
    @Override
    public StudentDTO findById(Long id) {
        loadData();
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new StudentNotFoundException(id));
    }

    private void loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
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
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            objectMapper.writeValue(file, this.students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

    @Override
    public int count() {
        return this.students.size();
    }

    @Override
    public void update(StudentDTO stu) {
        StudentDTO studentFound = findById(stu.getId());
        students.remove(studentFound);
        students.add(stu);
        this.saveData();
    }
}
