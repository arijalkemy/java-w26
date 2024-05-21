package org.ejercicio.joyerialasperlas.controller;

import org.ejercicio.joyerialasperlas.dto.JoyaCreateDto;
import org.ejercicio.joyerialasperlas.dto.JoyaCreatedDto;
import org.ejercicio.joyerialasperlas.dto.JoyaResponseDto;
import org.ejercicio.joyerialasperlas.dto.JoyaUpdateDto;
import org.ejercicio.joyerialasperlas.service.IJoyaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JoyaControllerTest {

    @Mock
    private IJoyaService joyaService;

    @InjectMocks
    private JoyaController joyaController;

    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    @DisplayName("Debería devolver un listado de todas las joyas")
    public void obtenerListadoJoyasTest() {
        //Arrange
        JoyaResponseDto joyaDto1 = new JoyaResponseDto();
        joyaDto1.setNombre("Anillo");
        joyaDto1.setMaterial("Oro");
        joyaDto1.setPeso(300);
        joyaDto1.setParticularidad("Ninguna");
        joyaDto1.setPoseePiedra(Boolean.FALSE);
        joyaDto1.setVentaONo(Boolean.TRUE);

        JoyaResponseDto joyaDto2 = new JoyaResponseDto();
        joyaDto2.setNombre("Anillo");
        joyaDto2.setMaterial("Plata");
        joyaDto2.setPeso(300);
        joyaDto2.setParticularidad("Ninguna");
        joyaDto2.setPoseePiedra(Boolean.FALSE);
        joyaDto2.setVentaONo(Boolean.TRUE);

        JoyaResponseDto joyaDto3 = new JoyaResponseDto();
        joyaDto3.setNombre("Anillo");
        joyaDto3.setMaterial("Acero");
        joyaDto3.setPeso(300);
        joyaDto3.setParticularidad("Ninguna");
        joyaDto3.setPoseePiedra(Boolean.FALSE);
        joyaDto3.setVentaONo(Boolean.TRUE);
        List<JoyaResponseDto> expected = List.of(joyaDto1, joyaDto2, joyaDto3);

        when(joyaService.obtenerJoyas()).thenReturn(expected);

        //Act
        ResponseEntity<List<JoyaResponseDto>> output = joyaController.obtenerJoyas();

        //Assert
        assertEquals(expected, output.getBody());
    }

    @Test
    @DisplayName("Debería devolver el id de la nueva joya creada")
    public void crearJoyaTest() {
        //Arrange
        JoyaCreateDto joyaCreateDto = new JoyaCreateDto();
        joyaCreateDto.setNombre("Anillo");
        joyaCreateDto.setMaterial("Oro");
        joyaCreateDto.setPeso(300);
        joyaCreateDto.setParticularidad("Ninguna");
        joyaCreateDto.setPoseePiedra(Boolean.FALSE);
        joyaCreateDto.setVentaONo(Boolean.TRUE);

        JoyaCreatedDto expected = new JoyaCreatedDto();
        expected.setId(1L);

        when(joyaService.guardarJoya(joyaCreateDto)).thenReturn(expected);

        //Act
        ResponseEntity<JoyaCreatedDto> output = joyaController.guardarJoya(joyaCreateDto);

        //Assert
        assertEquals(expected, output.getBody());
    }

    @Test
    @DisplayName("Deberia retornar un ResponseEntity con status OK al eliminar una joya")
    public void eliminarJoyaOKTest() {
        //Arrange
        Long id = 1L;
        Integer expectedStatus = 200;

        //Act
        ResponseEntity<?> output = joyaController.eliminarJoya(id);

        //Assert
        assertEquals(expectedStatus, output.getStatusCodeValue());
    }

    @Test
    @DisplayName("Deberia retornar la información de la joya actualizada")
    public void actualizarJoyaTest() {
        //Arrange
        Long id = 1L;

        JoyaUpdateDto input = new JoyaUpdateDto();
        input.setNombre("Anillo");
        input.setMaterial("Oro");
        input.setPeso(300);
        input.setParticularidad("Ninguna");
        input.setPoseePiedra(Boolean.FALSE);
        input.setVentaONo(Boolean.FALSE);

        JoyaResponseDto expected = modelMapper.map(input, JoyaResponseDto.class);

        when(joyaService.actualizarJoya(id, input)).thenReturn(expected);
        //Act
        ResponseEntity<JoyaResponseDto> output = joyaController.actualizarJoya(id,input);

        //Assert
        assertEquals(expected, output.getBody());
    }

}
