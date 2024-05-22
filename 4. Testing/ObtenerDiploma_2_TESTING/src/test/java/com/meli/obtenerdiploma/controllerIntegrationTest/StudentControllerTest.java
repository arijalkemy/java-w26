package com.meli.obtenerdiploma.controllerIntegrationTest;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();


    /**
     * Debe de mandar un httpstatus 400 badrequest debido a que no estamos mandando la informacion del
     * estudiante completa.
     * @throws MethodArgumentNotValidException
     */

    @Test
    public void registerUserNoOkTest() throws Exception
    {
        // Creacion del objeto student con atributos faltantes

        StudentDTO student = new StudentDTO.Builder()
                .studentName("Jose")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .content(mapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertThrows(MethodArgumentNotValidException.class, () -> {
                            throw result.getResolvedException();
                        })
                );
    }

    /**
     * Verificar el status code 200 cuando se mande la informacion completa del estudiante
     * studentName: Jose
     * id: 1001
     * subjects: [ { name: Matematicas, score: 10.0 } ]
     */
    @Test
    @DisplayName("Verificar el status code 200 cuando se mande la informacion completa del estudiante")
    public void registerUserOkTest() throws Exception
    {
        SubjectDTO subject = new SubjectDTO.Builder()
                .setName("Matematicas")
                .setScore(10.0)
                .build();
        StudentDTO student = new StudentDTO.Builder()
                .studentName("Jose")
                .subjects(List.of(subject))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .content(mapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
                );
    }


    /**
     * Verificar que se lanze la Exception si el alumno no existe
     * @throws StudentNotFoundException
     */
    @Test
    @DisplayName("Verificar que se lanze la Exception si el alumno no existe")
    public void getStudentNoOkTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1001L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertThrows(StudentNotFoundException.class, () -> {
                            throw result.getResolvedException();
                        })
                );
    }

    /**
     * Verificar que me regrese el student con id 1
     * studentName: Alexis
     * id: 1
     */

    @Test
    @DisplayName("Verficar que me regrese el student con id 1")
    public void getStudentOkTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Alexis"))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.averageScore").value("8.5")
                );
    }

    /**
     * Esto lo que hace internamente es llamar al metodo update del servicio, pero el servicio
     * lo que hace es llamar al metodo save del repository lo cual genera un registro nuevo en
     * el archivo de la data. Por lo tanto, el test no esta bien planteado.
     *
     * Nota para mi para el futuro: Refactorizar el codigo creando un metodo update en el repository
     * que realmente lo que haga sea actualizar la data de un registro ya existente. Posteriormente plantear
     * de manera presisa los tests de integracion para el controller y el service.
     */

    @Test
    @DisplayName("Debe de modificar el studentName con el id 1001 de Alexis a Maria")
    public void modifyStudentOkTest() throws Exception {
        StudentDTO student = new StudentDTO.Builder()
                .studentName("Maria")
                .subjects(List.of(new SubjectDTO.Builder().setName("Matematicas").setScore(10.0).build()))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .content(mapper.writeValueAsString(student))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()
                );
    }


    @Test
    @DisplayName("Verificar que el estatus sea correcto al eliminar el alumno con el id 1001")
    public void removeStudentOkTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudentNoOkTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1001)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()
                );
    }
}
