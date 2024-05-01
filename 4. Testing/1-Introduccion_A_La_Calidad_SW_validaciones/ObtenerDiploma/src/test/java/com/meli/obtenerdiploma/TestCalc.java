package com.meli.obtenerdiploma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestCalc {

    private Calc calculadora;


    @BeforeEach
    public void setup(){
        this.calculadora = new Calc();
    }
    @Test
    @DisplayName("Dos mas dos igual a cuatro")
    public void dosMasDosCuatro(){

        int resultado = calculadora.sumar(2,2);

        Assertions.assertEquals(4,resultado);
    }
    @Test
    @DisplayName("Dos menos dos es igual a cuatro")
    public void dosMenosDosEsCuatro(){
        int resultado = calculadora.restar(2,2);

        Assertions.assertEquals(0,resultado);
    }
    @Test
    public void dosMasDosCuatroMockeado(){

        Operacion operacionDeSuma = mock(Operacion.class);

        when(operacionDeSuma.resolver(2,2)).thenReturn(4);

        calculadora.setOperacion(operacionDeSuma);

        int resultado = calculadora.restar(2,2);

        //verify(operacionDeSuma).resolver(2,2);

        Assertions.assertEquals(0,resultado);
    }
}
