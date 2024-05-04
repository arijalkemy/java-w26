package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO, ILoadble {

    private Set<StudentDTO> students;
    private String sourceData = ResourceUtils.CLASSPATH_URL_PREFIX + "users.json";

    public StudentDAO() {
        this.load();
    }

    @Override
    public void save(StudentDTO stu) {
        boolean removed = this.delete(stu.getId());

        if (!removed)
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
            ret = true;
            this.saveData();

        } catch (StudentNotFoundException e) {
        }

        return ret;
    }

    @Override
    public StudentDTO findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new StudentNotFoundException(id));
    }




    public int countStudents() {
        return this.students.size();
    }

    public void load() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(this.sourceData);
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {
            });
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
            File file = ResourceUtils.getFile(this.sourceData);
            objectMapper.writeValue(file, this.students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

    public void setSourceData(String sourceData) {
        this.sourceData = sourceData;
    }

    @Override
    public boolean exists(StudentDTO stu) {
        if (stu == null || stu.getId() == null)
            return false;

        for (StudentDTO studentDTO : students) {
            if (stu.getId().equals(studentDTO.getId())) {
                return true;
            }
        } 
        return false;
    }
}
