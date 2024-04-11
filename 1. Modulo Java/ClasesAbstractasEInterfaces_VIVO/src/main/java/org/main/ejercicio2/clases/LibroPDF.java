package org.main.ejercicio2.clases;
import org.main.ejercicio2.interfaces.Documento;

public class LibroPDF implements Documento{
    private String titulo;
    private String autor;
    private String genero;
    private Integer paginas;

    public LibroPDF(String titulo, String autor, String genero, Integer paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
