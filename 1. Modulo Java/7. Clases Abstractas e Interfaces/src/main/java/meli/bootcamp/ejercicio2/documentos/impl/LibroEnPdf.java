package meli.bootcamp.ejercicio2.documentos.impl;

import meli.bootcamp.ejercicio2.documentos.Documento;

public class LibroEnPdf extends Documento {
  int cantidadDePaginas;
  String autor;
  String titulo;
  String genero;


  public LibroEnPdf(int cantidadDePaginas, String autor, String titulo, String genero) {
    this.cantidadDePaginas = cantidadDePaginas;
    this.autor = autor;
    this.titulo = titulo;
    this.genero = genero;
  }

  @Override
  public void imprimir() {
    System.out.println("Autor: " + this.autor);
    System.out.println("Título: " + this.titulo);
    System.out.println("Género: " + this.genero);
    System.out.println("Cantidad de páginas: " + this.cantidadDePaginas);
    System.out.println("--------------------------------------------------");
  }
}
