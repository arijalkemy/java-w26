package Model.archivos;

import Interface.IArchivo;

public class PDF implements IArchivo {
    public String nombreDelAutor;
    public String titulo;
    public String genero;
    public int cantDePaginas;


    public PDF(String nombreDelAutor, String titulo, String genero, int cantDePaginas) {
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantDePaginas = cantDePaginas;
    }

    public void imprimir() {
        System.out.println("PDF:");
        System.out.println(this.titulo + " por " + this.nombreDelAutor);
        System.out.println("Genero: " + this.genero);
        System.out.println("Cantidad de paginas: " + this.cantDePaginas);
    }
}
