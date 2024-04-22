package meli.bootcamp;

public class Inscripcion {
  private final Persona persona;
  private final Integer numeroInscripcion;
  private final Double precio;

  public Inscripcion(Persona persona, Integer numeroInscripcion, Double precio) {
    this.persona = persona;
    this.numeroInscripcion = numeroInscripcion;
    this.precio = precio;
  }

  public Double getPrecio() {
    return precio;
  }

  public Persona getPersona() {
    return persona;
  }

  public Integer getNumeroInscripcion() {
    return numeroInscripcion;
  }
}
