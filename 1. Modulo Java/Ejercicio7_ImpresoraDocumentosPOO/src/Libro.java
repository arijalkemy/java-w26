//Clase implementadora de la interface
public class Libro implements Impresora{
    //Atributos
    private String autor;
    private String titulo;
    private String genero;
    private int cantidadPaginas;
    //Constructor
    public Libro(String autor, String titulo, String genero, int cantidadPaginas){
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }
    //implementación de la firma del metodo definido desde la interface
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Libro...");
        System.out.println("Autor del libro: "+this.autor+"\r\n"+"Titulo del libro: "+this.titulo+"\r\n"
                +"Género del libro: "+this.genero+"\r\n"+"Número de páginas: "+this.cantidadPaginas+"\r\n");
    }
}
