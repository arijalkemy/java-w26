package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class App
{
    public static void main( String[] args )
    {

        Categoria categoria1 = new Categoria("circuito chico", "2km por selva y arroyo", 1500, 1300);
        Categoria categoria2 = new Categoria("circuito medio", "5km por selva y arroyo y barro", 2300, 2000 );
        Categoria categoria3 = new Categoria("circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra", 2800, 0);

        Participante participante1 = new Participante("42722343", "pepe", "perez", 22, 1154423, 334, "a+");


    }
}
