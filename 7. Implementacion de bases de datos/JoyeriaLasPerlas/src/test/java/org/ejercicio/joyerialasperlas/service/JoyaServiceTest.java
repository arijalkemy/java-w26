package org.ejercicio.joyerialasperlas.service;

import org.ejercicio.joyerialasperlas.dto.JoyaCreateDto;
import org.ejercicio.joyerialasperlas.dto.JoyaCreatedDto;
import org.ejercicio.joyerialasperlas.dto.JoyaResponseDto;
import org.ejercicio.joyerialasperlas.dto.JoyaUpdateDto;
import org.ejercicio.joyerialasperlas.exception.BadRequestException;
import org.ejercicio.joyerialasperlas.model.Joya;
import org.ejercicio.joyerialasperlas.repository.JoyaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JoyaServiceTest {

    @Mock
    private JoyaRepository joyaRepository;

    @InjectMocks
    private JoyaService joyaService;

    ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    @DisplayName("Debería guardar una joya y retornar JoyaCreatedDto")
    public void guardarJoyaTest() {
        //Arrange
        JoyaCreatedDto expected = new JoyaCreatedDto();
        expected.setId(1L);

        JoyaCreateDto joyaCreateDto = new JoyaCreateDto();
        joyaCreateDto.setNombre("Anillo");
        joyaCreateDto.setMaterial("Oro");
        joyaCreateDto.setPeso(300);
        joyaCreateDto.setParticularidad("Ninguna");
        joyaCreateDto.setPoseePiedra(Boolean.FALSE);
        joyaCreateDto.setVentaONo(Boolean.TRUE);

        Joya joya = modelMapper.map(joyaCreateDto, Joya.class);
        joya.setId(1L);

        when(joyaRepository.save(Mockito.any(Joya.class))).thenReturn(joya);

        //Act
        JoyaCreatedDto output = joyaService.guardarJoya(joyaCreateDto);

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería actualizar una joya y devolver la información de la joya actualizada")
    public void actualizarJoyaTest(){
        //Arrange
        JoyaUpdateDto joyaUpdateDto = new JoyaUpdateDto();
        joyaUpdateDto.setNombre("Anillo");
        joyaUpdateDto.setMaterial("Oro");
        joyaUpdateDto.setPeso(300);
        joyaUpdateDto.setParticularidad("Ninguna");
        joyaUpdateDto.setPoseePiedra(Boolean.FALSE);
        joyaUpdateDto.setVentaONo(Boolean.FALSE);

        JoyaResponseDto expected = new JoyaResponseDto();
        expected.setNombre("Anillo");
        expected.setMaterial("Oro");
        expected.setPeso(300);
        expected.setParticularidad("Ninguna");
        expected.setPoseePiedra(Boolean.FALSE);
        expected.setVentaONo(Boolean.FALSE);

        Joya joya = new Joya();

        Joya newJoya = new Joya();
        newJoya.setId(1L);
        newJoya.setNombre("Anillo");
        newJoya.setMaterial("Oro");
        newJoya.setPeso(300);
        newJoya.setParticularidad("Ninguna");
        newJoya.setPoseePiedra(Boolean.FALSE);
        newJoya.setVentaONo(Boolean.FALSE);

        when(joyaRepository.findById(1L)).thenReturn(Optional.of(joya));

        when(joyaRepository.save(Mockito.any(Joya.class))).thenReturn(newJoya);

        //Act
        JoyaResponseDto output = joyaService.actualizarJoya(1L, joyaUpdateDto);

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería retornar una lista de JoyaResponseDto")
    public void retornarListaJoyaTest() {
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

        JoyaResponseDto joyaDto4 = new JoyaResponseDto();
        joyaDto4.setNombre("Anillo");
        joyaDto4.setMaterial("Acero");
        joyaDto4.setPeso(300);
        joyaDto4.setParticularidad("Ninguna");
        joyaDto4.setPoseePiedra(Boolean.FALSE);
        joyaDto4.setVentaONo(Boolean.FALSE);

        List<Joya> mockList = List.of(modelMapper.map(joyaDto1, Joya.class) , modelMapper.map(joyaDto2, Joya.class),
                modelMapper.map(joyaDto3, Joya.class), modelMapper.map(joyaDto4, Joya.class));

        List<JoyaResponseDto> expected = List.of(joyaDto1, joyaDto2, joyaDto3);

        when(joyaRepository.findAll()).thenReturn(mockList);

        //Act
        List<JoyaResponseDto> output = joyaService.obtenerJoyas();

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería arrojar una excepción de tipo BadRequestException por intentar eliminar una joya en venta")
    public void arrojarBadRequestExceptionAlEliminarTest() {
        //Arrange
        Joya joya = new Joya();
        joya.setId(1L);
        joya.setNombre("Anillo");
        joya.setMaterial("Acero");
        joya.setPeso(300);
        joya.setParticularidad("Ninguna");
        joya.setPoseePiedra(Boolean.FALSE);
        joya.setVentaONo(Boolean.TRUE);
        when(joyaRepository.findById(1L)).thenReturn(Optional.of(joya));

        //Act and Assert
        assertThrows(BadRequestException.class, () -> joyaService.eliminarJoya(1L));
    }
}
