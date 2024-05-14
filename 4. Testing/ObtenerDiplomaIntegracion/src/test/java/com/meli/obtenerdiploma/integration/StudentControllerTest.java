package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    public static ObjectMapper mapper;

    public static ObjectWriter writer;

    @BeforeAll
    public static void setup() {
        writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        mapper = new ObjectMapper();

    }

    @Test
    public void RegisterStudentTest() throws Exception {
        StudentDTO stu = new StudentDTO(3l, "Julieta", "Hola", 7.0, List.of(
                new SubjectDTO("Lengua", 7.0),
                new SubjectDTO("Matematica", 7.0)
        ));

        String body = mapper.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void getStudentByIdTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andExpect(status().isOk());
    }

    @Test
    public void modifyStudentTest() throws Exception {

        StudentDTO stu = new StudentDTO(3l, "Julieta", "Chau", 7.0, List.of(
                new SubjectDTO("Lengua", 7.0),
                new SubjectDTO("Matematica", 7.0)
        ));

        String body = mapper.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void removeStudentTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 3))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getListStudentsTest() throws Exception {

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        JSONArray array = new JSONArray(responseBody);

        String ExpectedName = "Pedro";
        boolean isStudentFound = false;
        for (int i = 0; i < array.length(); i++) {
            JSONObject student = array.getJSONObject(i);

            if (student.getString("studentName").equals(ExpectedName)) {
                isStudentFound = true;
                break;
            }
        }

        assertThat(isStudentFound, is(true));
        System.out.println(responseBody);
    }

}
