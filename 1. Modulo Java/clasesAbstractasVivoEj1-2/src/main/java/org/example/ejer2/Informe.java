package org.example.ejer2;

public class Informe implements IImpresion{
    private int longitud;
    private int noPag;
    private String autor;
    private String revisor;

    public Informe(int text, int noPag, String autor, String revisor) {
        this.longitud = text;
        this.noPag = noPag;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getNoPag() {
        return noPag;
    }

    public void setNoPag(int noPag) {
        this.noPag = noPag;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void impresionDeInformacion() {
        String res = String.format("DATA: Autor: %s - Revisor %s - No. Pag: %d - Longitud: %d ",
                this.autor, this.revisor, this.noPag, this.longitud);
        System.out.println(res);
    }
}
