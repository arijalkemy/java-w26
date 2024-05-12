package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SaveDdataTest {
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private File file;

    @InjectMocks
    private StudentRepository studentRepository;

    @Test
    public void testSaveData() throws IOException {
        // Arrange
        Set<StudentDTO> students = new HashSet<>();
        // Agregar estudiantes al conjunto "students" según sea necesario

        doNothing().when(objectMapper).writeValue(any(File.class), any(Set.class));

        // Act
        studentRepository.findAll();

        // Assert
        verify(objectMapper, times(1)).writeValue(any(File.class), any(Set.class));
    }
}
