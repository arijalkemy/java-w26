package documents;

public class Libro implements ArchivoImprimible {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Libro(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public void imprimir() {
        System.out.println( "Libro{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}');
    }
}
