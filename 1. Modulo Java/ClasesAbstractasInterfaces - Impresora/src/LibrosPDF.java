public class LibrosPDF implements Impresora{
    private int cantidadDePaginas;
    private String nombreDeAutor;
    private String titulo;
    private String genero;



    @Override
    public void imprimir() {
        System.out.println( "Titulo: '" + titulo + '\n' +
                        "Cantidad de Paginas: " + cantidadDePaginas + '\n' +
                        "Nombre de autor: " + nombreDeAutor + '\n' +
                        "Genero: " + genero + '\n' );
    }

    public LibrosPDF(int cantidadDePaginas, String nombreDeAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDeAutor = nombreDeAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreDeAutor() {
        return nombreDeAutor;
    }

    public void setNombreDeAutor(String nombreDeAutor) {
        this.nombreDeAutor = nombreDeAutor;
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
    public String toString() {
        return "LibrosPDF{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreDeAutor='" + nombreDeAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
