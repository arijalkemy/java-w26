package Ejercicio2;

public class LibroPDF implements Imprimible{

    int cantidadPaginas;
    String autor;
    String titulo;
    String genero;

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
