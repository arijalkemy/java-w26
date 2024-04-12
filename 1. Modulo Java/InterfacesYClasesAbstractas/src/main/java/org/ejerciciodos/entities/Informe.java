package org.ejerciciodos.entities;

import org.ejerciciodos.interfaces.IDocumento;

import java.util.List;

public class Informe implements IDocumento {
    private String texto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe: " + texto + ", paginas: " + paginas + ", autor:" + autor + ", revisor:" + revisor);
    }
}
