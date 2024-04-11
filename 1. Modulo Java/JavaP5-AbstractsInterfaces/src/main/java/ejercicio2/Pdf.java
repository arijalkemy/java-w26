package ejercicio2;

public class Pdf {

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Pdf(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "PDF\n" + "Nombre: " + this.nombreAutor;
    }


}
