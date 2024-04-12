package org.example;

public class Informe implements Iimprimible{
    private int longitud;
    private int paginas;
    private String autor;
    private String revisor;

    public Informe(int longitud, int paginas, String autor, String revisor) {
        this.longitud = longitud;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimiendo() {
        System.out.println("autor: " + autor);
        System.out.println("revisor: " + revisor);
        System.out.println("paginas: " + paginas);
    }
}
