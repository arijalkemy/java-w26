package com.viajescuidados.viajescuidados.services;

import com.viajescuidados.repositories.IPersonasRepository;
import com.viajescuidados.services.PersonasService;
import com.viajescuidados.services.interfaces.IPersonaServiceInternal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonaServiceInternalTests {
    @Mock
    private IPersonasRepository personasRepository;

    @InjectMocks
    private IPersonaServiceInternal personasServiceInternal;

    @Test
    @DisplayName("Buscar a una persona existente")
    public void buscarPersonaPorId() {

    }
}
