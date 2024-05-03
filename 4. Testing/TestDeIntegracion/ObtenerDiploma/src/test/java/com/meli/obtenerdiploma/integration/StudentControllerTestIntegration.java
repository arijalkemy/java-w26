package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTestIntegration {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //TestUtilsGenerator.appendNewStudent(stu);
        StudentDTO stu2 = TestUtilsGenerator.getStudentWith3Subjects("Mariano");
        //TestUtilsGenerator.appendNewStudent(stu2);
    }
    @BeforeAll
    static void setupUP(){
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void registrarUsuario() throws Exception{
        StudentDTO payloadDTO= TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //con el objectWriter se puede convertir un objeto de tipo DTO en un string con su representacion a JSON
        ObjectWriter objectWriter= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson= objectWriter.writeValueAsString(payloadDTO);
         this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void obtenerUsuario() throws Exception{
        StudentDTO stu= TestUtilsGenerator.getStudentWith3Subjects("Marco");
        TestUtilsGenerator.appendNewStudent(stu);
        MvcResult mcvResult= this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/getStudent/{id}",9999L))
                .andDo(print()).andExpect(status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Marco"))
                .andReturn();
        assertEquals("application/json", mcvResult.getResponse().getContentType());
    }

    @Test
    public void modificarUsuario() throws Exception{
        StudentDTO payloadDTO= TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //con el objectWriter se puede convertir un objeto de tipo DTO en un string con su representacion a JSON
        ObjectWriter objectWriter= new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson= objectWriter.writeValueAsString(payloadDTO);
       this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print()).andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void eliminarUsuario() throws Exception{
        StudentDTO stu= TestUtilsGenerator.getStudentWithId(2L);
        //TestUtilsGenerator.appendNewStudent(stu);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/removeStudent/{id}",2L))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void listarUsuarios() throws Exception{
        Set<StudentDTO> studentDTOSet= TestUtilsGenerator.getStudentSet();
       MvcResult mcvResult= this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        assertEquals("application/json", mcvResult.getResponse().getContentType());
    }

}
