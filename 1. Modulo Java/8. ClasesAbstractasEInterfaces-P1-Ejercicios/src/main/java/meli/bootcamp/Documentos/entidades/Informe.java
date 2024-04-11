package meli.bootcamp.Documentos.entidades;

import meli.bootcamp.Documentos.interfaces.Documento;

public class Informe implements Documento {
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
