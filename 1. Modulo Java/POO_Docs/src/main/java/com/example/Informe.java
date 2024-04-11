package com.example;

public class Informe implements Imprimible {
    String texto;
    int cantidadPaginas;
    String autor;
    String revisor;


    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    @Override
    public void imprimir() {
        System.out.printf("El siguiente informe sobre avances cientificos ha obtenido innumerables reconocimientos." +
        " Fue realizado por %s con la ayuda de %s, agrupandolo en %d paginas." +
        " Se adjunta el texto en cuestion: %n%s%n",autor,revisor,cantidadPaginas,texto);
    }
    
}
