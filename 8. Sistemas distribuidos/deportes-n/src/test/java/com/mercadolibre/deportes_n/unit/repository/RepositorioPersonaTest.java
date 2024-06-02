package com.mercadolibre.deportes_n.unit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.deportes_n.repository.RepositorioPersona;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositorioPersonaTest {

    @Test
    @DisplayName("Test to verify get instance by Singleton pattern")
    public void verifyGetInstance() {
        //Arrange
        
        //Act
        RepositorioPersona instance1 = RepositorioPersona.getInstance(); 
        RepositorioPersona instance2 = RepositorioPersona.getInstance();
        //Assertions
        assertNotEquals(null, instance1);
        assertEquals(instance1, instance2);
    }



    @Test
    public void testSingletonBehavior() {
        RepositorioPersona instance1 = RepositorioPersona.getInstance();
        RepositorioPersona instance2 = RepositorioPersona.getInstance();

        assertSame(instance1, instance2, "Instances should be the same (singleton pattern)");
    }

    @Test
    public void testLoadMethod() {

        //Act
        RepositorioPersona systemUnderTest = RepositorioPersona.getInstance();
        systemUnderTest.load();
        
        //Assertions
        Assertions.assertTrue(systemUnderTest.getAll().size() > 0);

    }
}
