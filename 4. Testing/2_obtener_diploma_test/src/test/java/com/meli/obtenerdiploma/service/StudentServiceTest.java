package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentDAO studentMock;

    @Mock
    private IStudentRepository repositoryMock;

    @InjectMocks
    private StudentService underTest;

    @Test
    void givenStudent_whenCreate_callSave_test() {
        StudentDTO created = buildDto();
        underTest.create(created);
        verify(studentMock, times(1)).save(created);
    }

    @Test
    void givenStudent_whenDelete_callDelete_test() {
        long id = 1L;
        underTest.delete(id);
        verify(studentMock, times(1)).delete(id);
    }

    @Test
    void givenId_whenRead_thenStudentDto_test() {
        StudentDTO expected = buildDto();

        when(studentMock.findById(1L)).thenReturn(expected);

        StudentDTO result = underTest.read(1L);

        assertEquals(expected, result);
    }

    @Test
    void givenStudent_whenUpdate_thenCallSave_test() {
        StudentDTO toUpdate = buildDto();
        underTest.update(toUpdate);
        verify(studentMock, times(1)).save(toUpdate);
    }

    @Test
    void allStudent_test() {
        Set<StudentDTO> students = new HashSet<StudentDTO>();
        students.add(buildDto());


        when(repositoryMock.findAll()).thenReturn(students);

        Set<StudentDTO> result = underTest.getAll();

        assertArrayEquals(students.toArray(), result.toArray());
    }

    private StudentDTO buildDto() {
        StudentDTO mock = new StudentDTO();
        SubjectDTO aSubject = new SubjectDTO("A", 9.0);
        SubjectDTO bSubject = new SubjectDTO("B", 8.0);
        SubjectDTO cSubject = new SubjectDTO("C", 10.0);
        String resultMessage = "El alumno Leo ha obtenido un promedio de 9.0. Puedes mejorar";

        mock.setAverageScore(9.0);
        mock.setId(1L);
        mock.setSubjects(new ArrayList<>(List.of(aSubject, bSubject, cSubject)));
        mock.setStudentName(resultMessage);
        mock.setMessage(resultMessage);
        return mock;
    }

}
