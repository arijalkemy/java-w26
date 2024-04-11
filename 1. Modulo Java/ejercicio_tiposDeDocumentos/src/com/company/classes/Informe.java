package com.company.classes;

import com.company.interfaces.Imprimible;

public class Informe implements Imprimible {

    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println(
            "Informe{" +
                    "texto='" + texto + '\'' +
                    ", cantidadDePaginas=" + cantidadDePaginas +
                    ", autor='" + autor + '\'' +
                    ", revisor='" + revisor + '\'' +
                    '}'
        );
    }
}
