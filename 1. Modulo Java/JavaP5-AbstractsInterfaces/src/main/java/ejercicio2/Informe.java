package ejercicio2;

public class Informe {
    private String nombreAutor;
    private String revisor;
    private int cantidadPaginas;
    private String texto;


    public Informe(String nombreAutor, String revisor, int cantidadPaginas, String texto) {
        this.nombreAutor = nombreAutor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informe\n" + "Nombre: " + this.nombreAutor;
    }

}
