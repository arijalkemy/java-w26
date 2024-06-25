package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.representatives.RepresentativeResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Representative;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.IRepresentativeRepository;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces.RepresentativeServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
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
