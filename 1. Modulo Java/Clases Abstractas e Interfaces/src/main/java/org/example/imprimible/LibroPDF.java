package org.example.imprimible;

public class LibroPDF implements Imprimible{
    private Integer cantPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer cantPaginas, String nombreAutor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println( "Cantidad de paginas:" + cantPaginas +
                ", Nombre del autor:" + nombreAutor +
                ", Titulo:" + titulo +
                ", Género:" + genero);
    }

}
