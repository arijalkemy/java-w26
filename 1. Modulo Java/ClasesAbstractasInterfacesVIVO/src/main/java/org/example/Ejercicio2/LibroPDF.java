package org.example.Ejercicio2;

public class LibroPDF {
    String nombre;
    int numeroDePaginas;
    String autor;
    String genero;

    public LibroPDF(String nombre, int numeroDePaginas, String autor, String genero) {
        this.nombre = nombre;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "nombre='" + nombre + '\'' +
                ", numeroDePaginas=" + numeroDePaginas +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
