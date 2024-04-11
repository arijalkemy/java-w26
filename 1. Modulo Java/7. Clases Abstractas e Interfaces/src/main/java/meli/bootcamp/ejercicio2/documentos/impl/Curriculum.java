package meli.bootcamp.ejercicio2.documentos.impl;

import meli.bootcamp.ejercicio2.documentos.Documento;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documento {
  String nombre;
  String apellido;
  String direccion;
  String telefono;
  String email;
  List<String> experiencia;
  List<String> educacion;
  List<String> habilidades;

  public Curriculum(String nombre, String apellido, String direccion, String telefono, String email) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.direccion = direccion;
    this.telefono = telefono;
    this.email = email;
    this.experiencia = new ArrayList<>();
    this.educacion = new ArrayList<>();
    this.habilidades = new ArrayList<>();
  }

  @Override
  public void imprimir() {
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Apellido: " + this.apellido);
    System.out.println("Dirección: " + this.direccion);
    System.out.println("Teléfono: " + this.telefono);
    System.out.println("Email: " + this.email);

    System.out.println("Experiencia:");
    this.experiencia.forEach(System.out::println);

    System.out.println("Educación:");
    this.educacion.forEach(System.out::println);

    System.out.println("Habilidades:");
    this.habilidades.forEach(System.out::println);

    System.out.println("--------------------------------------------------");
  }

 public void agregarExperiencia(String experiencia) {
    this.experiencia.add(experiencia);
  }

  public void agregarEducacion(String educacion) {
    this.educacion.add(educacion);
  }

  public void agregarHabilidad(String habilidad) {
    this.habilidades.add(habilidad);
  }

}
