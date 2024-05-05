package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
            writer.print("[]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StudentDTO getStudentWith3Subjects(String name) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName(name);
        stu.setSubjects(subjects);

        return stu;
    }

    public static StudentDTO getStudentWith3SubjectsAverageOver9(String name) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 9.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName(name);
        stu.setSubjects(subjects);

        return stu;
    }

    public static StudentDTO getStudentWithId(Long id) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(id);
        stu.setStudentName("student1");
        stu.setSubjects(subjects);

        return stu;
    }

    public static Set<StudentDTO> getStudentSet() {
        List<SubjectDTO> list1 = 
        List.of(
            new SubjectDTO("Matemática", 9.0), 
            new SubjectDTO("Física", 7.0), 
            new SubjectDTO("Química", 6.0));

    List<SubjectDTO> list2 = 
        List.of(
            new SubjectDTO("Matemática", 10.0), 
            new SubjectDTO("Física", 8.0), 
            new SubjectDTO("Química", 4.0));

    StudentDTO studen1 = new StudentDTO(1L, "Juan", null, null, list1);
    StudentDTO studen2 = new StudentDTO(2L, "Pedro", null, null, list2);

    return Set.of(studen2, studen1);
    }

    public static void appendNewStudent(StudentDTO stu) {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String pathFile = "./src/" + SCOPE + "/resources/users.json";

        File file;
        PrintWriter writer;
        try {
            file = ResourceUtils.getFile(pathFile);
            writer = new PrintWriter(file);
            String content = Files.readString(file.getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            try {
                String studentAsString = mapper.writeValueAsString(stu);
                writer.print(content.substring(0, content.length() - 1));
                if (content.length() > 2)
                    writer.print(", ");
                writer.print(studentAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StudentDTO getFirstStudent() {
        List<SubjectDTO> list1 = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
                
        Double averageScore = (9.0 + 7.0 + 6.0)/3.0;
        String message = "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.";
        StudentDTO studen1 = new StudentDTO(1L, "Juan", message, averageScore, list1);
        return studen1;
    }


    public static StudentDTO getFirstStudentNotCalculated() {
        List<SubjectDTO> list1 = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0));
                
        StudentDTO studen1 = new StudentDTO(1L, "Juan", null, null, list1);
        return studen1;
    }


    public static StudentDTO getNewStudent() {
        List<SubjectDTO> list1 = List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 10.0),
                new SubjectDTO("Química", 10.0));
                
        StudentDTO studen1 = new StudentDTO(null, "Antonio I", null, null, list1);
        return studen1;
    }
}
