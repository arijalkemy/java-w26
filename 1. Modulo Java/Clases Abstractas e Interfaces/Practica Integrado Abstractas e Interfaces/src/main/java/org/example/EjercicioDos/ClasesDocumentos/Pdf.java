package org.example.EjercicioDos.ClasesDocumentos;

import org.example.EjercicioDos.InterfacesDocumentos.Imprimir;

public class Pdf implements Imprimir {

    int cantidadPaginas = 20;
    String nombreAutor = "Pedro";
    String titulo = "Libro 1";
    String genero = "Deportes";


    @Override
    public void imprimirArchivo() {
        System.out.println("Nombre: "+ nombreAutor + "Titulo: "+ titulo + "Genero: " + genero);
    }
}
