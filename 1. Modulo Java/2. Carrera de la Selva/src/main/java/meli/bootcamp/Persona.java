package meli.bootcamp;

public class Persona {
  private final int numeroParticipante;
  private final int dni;
  private final String nombre;
  private final String apellido;
  private final int edad;
  private final int celular;
  private final int numeroEmergencia;
  private final String grupoSanguineo;

  public Persona(int numeroParticipante, int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo) {
    this.numeroParticipante = numeroParticipante;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.celular = celular;
    this.numeroEmergencia = numeroEmergencia;
    this.grupoSanguineo = grupoSanguineo;
  }

  public int getNumeroParticipante() {
    return numeroParticipante;
  }

  public int getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public int getEdad() {
    return edad;
  }

  public int getCelular() {
    return celular;
  }

  public int getNumeroEmergencia() {
    return numeroEmergencia;
  }

  public String getGrupoSanguineo() {
    return grupoSanguineo;
  }
}
