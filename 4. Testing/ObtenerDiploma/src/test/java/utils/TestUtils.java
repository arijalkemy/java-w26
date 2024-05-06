package utils;

import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import spring.obtenerdiploma.model.StudentDTO;
import spring.obtenerdiploma.model.SubjectDTO;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class TestUtils {
    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void loadDataTestUsers() {

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.println("[]");
        writer.close();
    }

    public static StudentDTO createStudentDTOWithTwoSubjects() {
        return createStudent(777L, "Marcela", 9.0, List.of(
                createSubject("Matemática", 10.0),
                createSubject("Literatura", 8.0)
        ));
    }
    public static StudentDTO createStudentDTOWithThreeSubjects() {
        return createStudent(777L, "Marcela", 9.0, List.of(
                createSubject("Matemática", 10.0),
                createSubject("Literatura", 8.0),
                createSubject("Ingles", 9.0)
        ));
    }
    public static StudentDTO createStudentDTO(Long id) {
        return createStudent(id, "Marcela", 9.0, List.of(
                createSubject("Matemática", 10.0),
                createSubject("Literatura", 8.0)
        ));
    }

    public static StudentDTO createStudent(Long id, String studentName, Double averageScore, List<SubjectDTO> subjects) {
        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName(studentName);
        student.setAverageScore(averageScore);
        student.setSubjects(subjects);
        return student;
    }

    public static SubjectDTO createSubject(String name, Double score) {
        SubjectDTO subject = new SubjectDTO();
        subject.setName(name);
        subject.setScore(score);
        return subject;
    }
}
