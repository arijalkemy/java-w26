package org.example;
//clase del objerto Informes que implementa la interfaz iprimible
public class Informes implements Imprimible{
    private int longitud;
    private int paginas;
    private String autor;
    private String revisor;
    //Constructor de la clase
    public Informes(int longitud, int paginas, String autor, String revisor) {
        this.longitud = longitud;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }
    //metodo imprimir que sobreescribe el metodo de la interfaz
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe de "+autor);
    }
}
