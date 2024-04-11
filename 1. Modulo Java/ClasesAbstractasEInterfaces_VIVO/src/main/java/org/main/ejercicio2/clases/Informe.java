package org.main.ejercicio2.clases;
import org.main.ejercicio2.interfaces.Documento;

public class Informe implements Documento {
    private Integer paginas;
    private String autor;
    private String revisor;
    private String contenido;

    public Informe(Integer paginas, String autor, String revisor, String contenido) {
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
