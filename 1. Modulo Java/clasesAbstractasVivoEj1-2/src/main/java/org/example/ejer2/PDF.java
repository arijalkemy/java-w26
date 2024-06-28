package org.example.ejer2;

public class PDF implements IImpresion{
    private int noPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public PDF(int noPaginas, String autor, String titulo, String genero) {
        this.noPaginas = noPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }



    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
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

    @Override
    public void impresionDeInformacion() {
        String res = String.format("Data: Titulo %s - Autor: %s - No. Pag: %d - Genero: %s",
                this.titulo, this.autor, this.noPaginas, this.genero);
        System.out.println(res);
    }
}
