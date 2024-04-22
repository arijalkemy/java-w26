package meli.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
  private final String nombre;
  private final String descripcion;
  Integer edadMinima;
  Double precioMin;
  Double precioMax;
  Integer edadDeCorte;
  List<Inscripcion> inscriptos;

  public Categoria(
      String nombre, String descripcion, Integer edadMinima,
      Double precioMin, Double precioMax, Integer edadDeCorte
  ) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.edadMinima = edadMinima;
    this.precioMin = precioMin;
    this.precioMax = precioMax;
    this.edadDeCorte = edadDeCorte;
    this.inscriptos = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public boolean sePuedeInscribir(Persona persona) {
    return persona.getEdad() >= edadMinima;
  }

  public Double getPrecio(Persona persona) {
    if (persona.getEdad() >= edadDeCorte) {
      return precioMax;
    }

    return precioMin;
  }

  public void inscribir(Persona persona) {
    if (!sePuedeInscribir(persona)) {
      System.out.println(
          "No se puede inscribir a " + persona.getNombre() + " en la categoria " + nombre + "\n"
      );
    }

    Integer numeroDeInscripcion = inscriptos.size() + 1;
    Inscripcion inscripcion = new Inscripcion(persona, numeroDeInscripcion, getPrecio(persona));
    inscriptos.add(inscripcion);
  }

  public void desInscribir(Persona persona) {
    Inscripcion inscripcion = inscriptos.stream()
        .filter(i -> i.getPersona().equals(persona))
        .findFirst()
        .orElseThrow(
            () -> new RuntimeException("La persona no esta inscripta en la categoria " + nombre)
        );

    inscriptos.remove(inscripcion);
  }

  public void imprimirInscriptos() {
    System.out.println("Categoria: " + nombre);
    System.out.println("---------");

    for (Inscripcion inscripcion : inscriptos) {
      System.out.println("Inscripcion: " + inscripcion.getNumeroInscripcion());
      System.out.println("Nombre: " + inscripcion.getPersona().getNombre());
      System.out.println("Apellido: " + inscripcion.getPersona().getApellido());
      System.out.println("Edad: " + inscripcion.getPersona().getEdad());
      System.out.println("Precio: " + inscripcion.getPrecio());
      System.out.println("---------");
    }

    System.out.println("Monto total: " + montoTotal());
    System.out.println("===========" + "\n");
  }

  public Double montoTotal() {
    return inscriptos.stream().mapToDouble(Inscripcion::getPrecio).sum();
  }
}
