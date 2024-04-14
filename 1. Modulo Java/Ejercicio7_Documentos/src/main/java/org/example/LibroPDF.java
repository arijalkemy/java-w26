package org.example;

public class LibroPDF implements Impresora{

    private int cantPaginas;
    private String nombre;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String nombre, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombre = nombre;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
        System.out.println("cantPaginas: " + cantPaginas);
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
