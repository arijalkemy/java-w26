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

    private static ObjectWriter mapper;

    public static void emptyUsersFile() throws JsonProcessingException {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("classpath:users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        List<StudentDTO> studentDTOList = getAllStudentsJson();
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String studentsStr = objectWriter.writeValueAsString(studentDTOList);

        writer.print(studentsStr);
        writer.close();
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

    static List<StudentDTO> getAllStudentsJson() {
        StudentDTO studentOne = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematica", 9.0),
                        new SubjectDTO("Fisica", 7.0),
                        new SubjectDTO("Quimica", 6.0)
                )
        );

        StudentDTO studentTwo = new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Fisica", 8.0),
                        new SubjectDTO("Quimica", 4.0)
                )
        );

        return List.of(studentOne, studentTwo);
    }

    public static StudentDTO getUserJsonRecord(Long id) {
        SubjectDTO subject1 = new SubjectDTO("Matematica", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 6.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(id);
        stu.setStudentName("Juan");
        stu.setMessage("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.");
        stu.setAverageScore(7.333333333333333);
        stu.setSubjects(subjects);

        return stu;
    }

    public static Set<StudentDTO> getStudentSet() {
        StudentDTO stu1 = getStudentWith3Subjects("Marco");
        StudentDTO stu2 = getStudentWith3Subjects("Marco Polo");
        StudentDTO stu3 = getStudentWith3Subjects("Julio");
        StudentDTO stu4 = getStudentWith3Subjects("Julio Cesar");
        List<StudentDTO> students = getAllStudentsJson();

        return new HashSet<StudentDTO>() {{
            add(stu1);
            add(stu2);
            add(stu3);
            add(stu4);
            addAll(students);
        }};
    }

    public static void appendNewStudent(StudentDTO stu) {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("classpath:users.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("classpath:users.json"));

            try {
                String studentAsString = mapper.writeValueAsString(stu);
                writer.print(content.substring(0, content.length() - 1));
                if (content.length() > 2) writer.print(", ");
                writer.print(studentAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.close();
    }

}
