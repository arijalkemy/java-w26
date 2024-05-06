package meli.bootcamp.obtenerdiplomacrud.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.obtenerdiplomacrud.model.StudentDTO;
import meli.bootcamp.obtenerdiplomacrud.model.SubjectDTO;
import org.junit.jupiter.api.*;

import java.util.List;

class StudentDAOTest {

    IStudentDAO studentDAO;
    StudentDTO student;

    @BeforeEach @AfterEach
    void setUp() {
        studentDAO = new StudentDAO();
        student = new StudentDTO(1L, "Juan", null, null, List.of(
                new SubjectDTO("Matemática", 9D),
                new SubjectDTO("Física", 7D),
                new SubjectDTO("Química", 6D)
        ));
    }

    @Test
    @DisplayName("Save student")
    void save() {
        student.setStudentName("Lucas");
        student.setId(3L);
        studentDAO.save(student);

        StudentDTO obtained = studentDAO.findById(3L);

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(3L, obtained.getId());

    }

    @Test
    @DisplayName("Delete student")
    void delete() {
        student.setStudentName("Pedro");
        student.setId(4L);
        studentDAO.save(student);

        boolean obtained = studentDAO.delete(4L);

        Assertions.assertTrue(obtained);
    }

    @Test
    @DisplayName("Check if student Exists")
    void existsTest() {
        boolean obtained = studentDAO.exists(student);

        Assertions.assertTrue(obtained);

    }

    @Test
    @DisplayName("Find student by id")
    void findByIdTest() throws JsonProcessingException {
        Long id = 1L;

        StudentDTO obtained = studentDAO.findById(id);

        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(id, obtained.getId());
        Assertions.assertEquals(ow.writeValueAsString(obtained), ow.writeValueAsString(student));
    }
}