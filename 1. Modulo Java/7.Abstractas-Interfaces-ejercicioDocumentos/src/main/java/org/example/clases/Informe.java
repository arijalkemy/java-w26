package org.example.clases;

import org.example.interfaces.Documento;

public class Informe implements Documento {
    private String longitud;
    private int paginas;
    private String autor;
    private  String revisor;

    public Informe(String longitud, int paginas, String autor, String revisor) {
        this.longitud = longitud;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void Imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Informe{" +
                "longitud='" + longitud + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
