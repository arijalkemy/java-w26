package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    private final String url = "/student";
    private Set<StudentDTO> students;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();

    private MvcResult checkStudentDTOResponse(ResultActions mvcResult, StudentDTO student) throws Exception {
        return mvcResult.andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(student.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(student.getMessage()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(student.getAverageScore()))
                .andReturn();
    }

    private StudentDTO getFirstStudent(){
        Optional<StudentDTO> student = students.stream().findFirst();
        return student.get();
    }

    @BeforeEach
    public void setup() {
        students = TestUtilsGenerator.getStudentSet();
        TestUtilsGenerator.reestartJsonFile(students);
    }

    @Test
    public void registerStudentTestOk() throws Exception {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Hernan");

        // act
        controller.registerStudent(stu);
        String payloadJson = writer.writeValueAsString(stu);

        //Assert
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(url + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    @DisplayName(url + "getStudent/{id}")
    public void getStudentTestOk() throws Exception {
        // arrange
        StudentDTO stu = students.stream().findFirst().get();
        Long id = stu.getId();
        when(service.read(stu.getId())).thenReturn(stu);
        // act
        StudentDTO readStu = controller.getStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        ResultActions mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url + "/getStudent/{id}", 1L))
                .andDo(print());

        checkStudentDTOResponse(mvcResult, stu);

    }

    @Test
    public void modifyStudent() throws Exception {
        // arrange
        StudentDTO stu = getFirstStudent();
        stu.setId(9999L);
        String payloadJSON = writer.writeValueAsString(stu);
        // act
        controller.modifyStudent(stu);

        // assert
        verify(service, atLeastOnce()).update(stu);
        ResultActions result = this.mockMvc.perform(
                        MockMvcRequestBuilders.post(url + "/modifyStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON)
                ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void removeStudentTest() throws Exception {
        // arrange
        StudentDTO stu = getFirstStudent();
        String payloadJSON = writer.writeValueAsString(stu);
        // act
        controller.removeStudent(stu.getId());

        // assert
        MvcResult result = this.mockMvc.perform(
                MockMvcRequestBuilders.get(url + "/removeStudent/{id}", stu.getId())
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        verify(service, atLeastOnce()).delete(1L);

    }

    @Test
    public void listStudents() {
        // arrange
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = controller.listStudents();

        // assert
        verify(service, atLeastOnce()).getAll();

        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}

