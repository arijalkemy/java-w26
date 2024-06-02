package com.mercadolibre.deportes_n.unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.deportes_n.repository.RepositorioDeporte;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositorioDeporteTest {
   
    
    @Test
    @DisplayName("Test to verify load deportes into RepositorioDeporte")
    public void verifyLoadRepositorioDeporte() {
        
        //Arrange
        RepositorioDeporte instance = RepositorioDeporte.getInstance();
        //Act
        instance.load();   
        //Assertions 
        assertTrue(instance.getAll().size() > 0);
    }

    @Test
    @DisplayName("Test to verify singleton by RepositorioDeporte")
    public void verifySingletonRepositorioDeporte() {
        //Arrange and act
        RepositorioDeporte instance1 = RepositorioDeporte.getInstance();
        RepositorioDeporte instance2 = RepositorioDeporte.getInstance();

        //Act
        RepositorioDeporte.getInstance().load();
        
        //Assertions
        assertNotEquals(null, instance2);
        assertNotEquals(null, instance1);
        assertEquals(instance1, instance2);
    }

}
