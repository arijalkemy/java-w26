package org.example.EjercicioDos.ClasesDocumentos;

import org.example.EjercicioDos.InterfacesDocumentos.Imprimir;

public class Curriculums implements Imprimir {
    String nombre = "Curriculum";

    @Override
    public void imprimirArchivo() {
        System.out.println("Imprimiendo, " + nombre );
    }
}
