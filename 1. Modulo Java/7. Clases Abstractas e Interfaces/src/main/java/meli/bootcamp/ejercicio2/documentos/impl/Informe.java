package meli.bootcamp.ejercicio2.documentos.impl;

import meli.bootcamp.ejercicio2.documentos.Documento;

public class Informe extends Documento {
  String texto;
  int cantidadDePaginas;
  String autor;
  String revisor;

  public Informe(int cantidadDePaginas, String autor, String revisor, String texto) {
    this.cantidadDePaginas = cantidadDePaginas;
    this.autor = autor;
    this.revisor = revisor;
    this.texto = texto;
  }

  @Override
  public void imprimir() {
    System.out.println("Cantidad de páginas: " + this.cantidadDePaginas);
    System.out.println("Autor: " + this.autor);
    System.out.println("Revisor: " + this.revisor);
    System.out.println("Texto: " + this.texto);
    System.out.println("--------------------------------------------------");
  }
}
