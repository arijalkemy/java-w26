package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Representative;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IRepresentativeRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces.RepresentativeServiceImpl;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.MessageError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RepresentativeServiceTest {
    @Mock
    private IRepresentativeRepository repository;

    @InjectMocks
    private RepresentativeServiceImpl service;

    @Test
    @DisplayName("get representative by id")
    public void getRepresentativeById() {
        // Arrange
        Long id = 1L;
        Representative representative = new Representative(id, "Edwin Villarraga");
        RepresentativeResponseDto expected = new RepresentativeResponseDto(id, "Edwin Villarraga");

        // Act
        when(repository.findById(id)).thenReturn(Optional.of(representative));
        RepresentativeResponseDto current = service.findById(id);

        // Assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @DisplayName("get representative by id not found")
    public void getRepresentativeByIdNotFound() {
        // Arrange
        Long id = 10L;
        String exMessage = MessageError.REPRESENTATIVE_NOT_FOUND.getMessage();

        // Act
        when(repository.findById(id)).thenReturn(Optional.empty());
        NotFoundException actual = Assertions.assertThrows(NotFoundException.class, () -> service.findById(id));

        // Assert
        Assertions.assertEquals(exMessage, actual.getMessage());
    }
}
