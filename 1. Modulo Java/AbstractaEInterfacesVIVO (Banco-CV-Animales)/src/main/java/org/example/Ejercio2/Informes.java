package org.example.Ejercio2;

public class Informes implements Imprimible {
    //Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.

    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, String revisor, String autor, int cantPaginas) {
        this.texto = texto;
        this.revisor = revisor;
        this.autor = autor;
        this.cantPaginas = cantPaginas;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Informes:" );
        System.out.println("Texto:" + this.texto);
        System.out.println("cantidad de pag:" + this.cantPaginas);
        System.out.println("Autor:" + this.autor);
        System.out.println("revisor:" + this.revisor);
    }

    public String getTexto() {
        return texto;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getRevisor() {
        return revisor;
    }


}
