package meli.bootcamp.ejercicio2;

import meli.bootcamp.ejercicio2.documentos.Documento;
import meli.bootcamp.ejercicio2.documentos.impl.Curriculum;
import meli.bootcamp.ejercicio2.documentos.impl.Informe;
import meli.bootcamp.ejercicio2.documentos.impl.LibroEnPdf;

import java.util.Arrays;
import java.util.List;

public class Ejercicio2 {
  public static void main(String[] args) {
    LibroEnPdf libro = new LibroEnPdf(
        99, "Antoine de Saint-Exupéry", "El principito", "Infantil"
    );

    Informe informe = new Informe(
    10, "Juan Perez", "Maria Gomez", "Informe de ventas"
    );

    Curriculum curriculum = new Curriculum(
    "Juan", "Perez", "Buenos Aires", "1234", "juan@gmail.com"
    );

    curriculum.agregarEducacion("UTN - Ingeniería en Sistemas");
    curriculum.agregarExperiencia("MELI - Software Developer");
    curriculum.agregarHabilidad("Java");

    List<Documento> documentosParaImprimir = Arrays.asList(libro, informe, curriculum);

    documentosParaImprimir.forEach(Documento::imprimir);
  }
}
