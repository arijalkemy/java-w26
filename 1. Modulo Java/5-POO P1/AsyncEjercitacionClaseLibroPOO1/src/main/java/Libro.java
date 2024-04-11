public class Libro {

   private String titulo;
    private String autor;
    private int ejemplares;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadEjemplares(){
        return ejemplares;
    }

    public  String mostrarLibro(){
        return " Titulo: " + titulo + " Autor: " + autor + " Ejemplares: " + ejemplares;
    }
}
