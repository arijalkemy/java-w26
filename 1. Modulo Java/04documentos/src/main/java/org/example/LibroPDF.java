package org.example;

public class LibroPDF implements IImprimible {
    private String nombre;
    private String autor;
    private String genero;
    private Integer cantidadDePaginas;

    public LibroPDF(String nombre, String autor, String genero, Integer cantidadDePaginas) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.cantidadDePaginas = cantidadDePaginas;
    }

    @Override
    public void imprimir() {
        System.out.println(this.nombre);
        System.out.println("Autor: " + this.autor);
        System.out.println("Género: " + this.genero);
        System.out.println("Cantidad de Paginas: " + this.cantidadDePaginas);
        System.out.println("\n");
    }
}

