package meli.bootcamp;

public class Persona {
  String nombre;
  int edad;
  String dni;
  float pesoEnKg;
  float alturaEnM;

  public Persona() {
  }

  public Persona(int edad, String nombre, String dni) {
    this.edad = edad;
    this.nombre = nombre;
    this.dni = dni;
  }

  public Persona(String nombre, int edad, String dni, float pesoEnKg, float altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    this.pesoEnKg = pesoEnKg;
    this.alturaEnM = altura;
  }

  public int calcularImc() {
    float imc = pesoEnKg / alturaEnM * alturaEnM;

    if (imc < 20) {
      return -1;
    }

    if (imc <= 25) {
      return 0;
    }

    return 1;
  }

  public boolean esMayorDeEdad() {
    return edad >= 18;
  }

  public String toString() {
    return "Persona {" +
      "nombre='" + nombre + '\'' +
      ", edad=" + edad +
      ", dni='" + dni + '\'' +
      ", pesoEnKg=" + pesoEnKg +
      ", alturaEnM=" + alturaEnM +
      " }";
  }
}
