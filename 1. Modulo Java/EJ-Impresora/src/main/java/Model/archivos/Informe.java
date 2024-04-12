package Model.archivos;

import Interface.IArchivo;

public class Informe implements IArchivo {
    public int longitud;
    public int cantDePaginas;
    public String autor;
    public String revisor;

    public Informe(int longitud, int cantdePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantDePaginas = cantdePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    public void imprimir() {
        System.out.println("INFORME:");
        System.out.println("Autor: " + this.autor + " | Revisor: " + this.revisor);
        System.out.println("Longitud: " + this.longitud);
        System.out.println("Cantidad de paginas: " +this.cantDePaginas);
    }
}
