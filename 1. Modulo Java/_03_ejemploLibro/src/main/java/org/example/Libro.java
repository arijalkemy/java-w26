package org.example;

public class Libro {
    private String autor;
    private String titulo;
    private int ejemplares;

    public Libro(String titulo, String autor, int ejemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadDeEjemplares(){
        return ejemplares;
    }

    public static void probando(){
        System.out.println("Podemos hacer metodos estaticos en clases NO estaticas");
    }

    public String mostrarLibro(){
        return "Titulo: " + titulo + ". Autor: " + autor + ". Ejemplares: " + ejemplares;
    }
}
