package org.example;

import java.util.List;

public class Curriculum implements Imprimir{
    private String nombre;
    private String apellido;
    private String dni;
    private List<String> aptitudes;

    @Override
    public void imprimir() {
        System.out.println("imprimiendo curriculum");
    }
}
