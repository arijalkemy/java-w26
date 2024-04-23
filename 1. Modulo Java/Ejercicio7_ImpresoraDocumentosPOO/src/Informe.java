//Clase implementadora de la interface
public class Informe implements Impresora{
    //Atributos
    private String autor;
    private String revisor;
    private String texto;
    private int cantidadPaginas;
    //Constructor
    public Informe(String autor, String revisor, String texto, int cantidadPaginas){
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
    }
    //implementación de la firma del metodo definido desde la interface
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Libro...");
        System.out.println("Autor del informe: "+this.autor+"\r\n"+"Revisor del informe: "+this.revisor+"\r\n"
                +"Texto: "+this.texto+"\r\n"+"Número de páginas: "+this.cantidadPaginas+"\r\n");
    }
}
