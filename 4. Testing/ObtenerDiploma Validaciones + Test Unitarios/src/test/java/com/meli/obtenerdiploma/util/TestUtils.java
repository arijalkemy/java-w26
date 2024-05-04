package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

public class TestUtils {
    public static StudentDTO createStudentDTO() {
        return new StudentDTO(1L,"Pepito","Mensaje", 3.6,
                List.of());
    }

    public static StudentDTO createPersonalizedStudentDTO(Long id, String name, String mensaje, Double averageScore,
                                                          List<SubjectDTO> subjects) {
        return new StudentDTO(id, name, mensaje, averageScore, subjects);
    }

    public static void deleteInfoRepository() {
        try {
            File file = ResourceUtils.getFile("./src/main/resources/users.json");
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(file, List.of());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<StudentDTO> loadData() {
        List<StudentDTO> studentDTOList = List.of(
                new StudentDTO(1L,"Pepito","Mensaje", 3.6,
                        List.of(new SubjectDTO("Matematicas", 9.0))),
                new StudentDTO(2L,"Pepito 2","Mensaje", 4.0,
                        List.of(new SubjectDTO("Biología", 7.0))),
                new StudentDTO(3L,"Pepito 3","Mensaje", 10.0,
                        List.of(new SubjectDTO("Sociales", 4.5)))
        );
        try {
            File file = ResourceUtils.getFile("./src/main/resources/users.json");
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(file, studentDTOList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentDTOList;
    }
}
