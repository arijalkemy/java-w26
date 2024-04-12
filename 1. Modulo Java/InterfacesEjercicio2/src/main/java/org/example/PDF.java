package org.example;

public class PDF implements Iimprimible{
    private int paginas;
    private String autor;
    private String titulo;
    private String genero;

    public PDF(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
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
    public void imprimiendo() {
        System.out.println("autor: " + autor);
        System.out.println("titulo: " + titulo);
        System.out.println("genero: " + genero);
        System.out.println("paginas: " + paginas);

    }
}
