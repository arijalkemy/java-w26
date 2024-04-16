package org.example.Ejercio2;

public class LibrosPDF implements Imprimible {
   // Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
     private int canPaginas;
     private String nombreAutor;
     private String titulo;
     private String genero;

    public LibrosPDF(int canPaginas, String genero, String titulo, String nombreAutor) {
        this.canPaginas = canPaginas;
        this.genero = genero;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
    }

    @Override
    public void imprimirDocumento() {

        System.out.println("Libros en PDF:");
        System.out.println("Cantidad de paginas:" + this.canPaginas);
        System.out.println("Genero:" + this.genero);
        System.out.println("Autor:" + this.nombreAutor);
        System.out.println("Titulo:" + this.titulo);



    }


    public int getCanPaginas() {
        return canPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }


}
