package com.mercadolibre.deportes_n.unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.deportes_n.repository.RepositorioDeporte;
import com.mercadolibre.deportes_n.repository.RepositorioDeportePersona;
import com.mercadolibre.deportes_n.repository.RepositorioPersona;

@ExtendWith(MockitoExtension.class)
public class RepositorioDeportePersonaTest {
    

    @Test
    @DisplayName("Test to verify singleton RepositorioDeportePersona")
    public void verifySingletonRepositorioPersona() {
        //Arrange and act
        RepositorioDeportePersona instance1 = RepositorioDeportePersona.getInstance();
        RepositorioDeportePersona instance2 = RepositorioDeportePersona.getInstance();

        //Assertion
        assertNotEquals(null, instance2);
        assertNotEquals(null, instance1);
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("Test to verify load  RepositorioDeportePersona")
    public void verifyLoadRepositorioPersona() {
        //Arrange and act
        RepositorioDeporte.getInstance().load();
        RepositorioPersona.getInstance().load();
        RepositorioDeportePersona.getInstance().load();
        
        RepositorioDeportePersona instance1 = RepositorioDeportePersona.getInstance();

        //Act
        instance1.load();

        //Assertion
        assertTrue(instance1.getAll().size() > 0 );
    }


}
