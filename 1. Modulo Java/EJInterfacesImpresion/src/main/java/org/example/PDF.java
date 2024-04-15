package org.example;
//clase del objerto PDF que implementa la interfaz iprimible
public class PDF implements Imprimible{
    private int paginas;
    private String nombre;
    private String autor;
    private String titulo;
    private String genero;
    //Constructor de la clase
    public PDF(int paginas, String nombre, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.nombre = nombre;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }
    //metodo imprimir que sobreescribe el metodo de la interfaz
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo pdf del libro " + nombre);
    }
}
