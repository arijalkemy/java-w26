public class LibroPDF implements Imprimible{
    private int numPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int numPaginas, String autor, String titulo, String genero) {
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro en PDF:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + genero);
        System.out.println("Número de páginas: " + numPaginas);
    }
}
