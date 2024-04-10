package meli.bootcamp;

public class Persona {
  String nombre;
  int edad;
  String dni;
  double pesoEnKg;
  double alturaEnM;

  public Persona() {
  }

  public Persona(int edad, String nombre, String dni) {
    this.edad = edad;
    this.nombre = nombre;
    this.dni = dni;
  }

  public Persona(String nombre, int edad, String dni, double pesoEnKg, double altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    this.pesoEnKg = pesoEnKg;
    this.alturaEnM = altura;
  }

  public int calcularImc() {
    double imc = pesoEnKg / Math.pow(alturaEnM, 2);

    if (imc < 20) {
      return -1;
    }

    if (imc <= 25) {
      return 0;
    }

    return 1;
  }

  public boolean esMayorDeEdad() {
    return edad <= 18;
  }

  public String toString() {
    return "Persona {" +
        "nombre = '" + nombre + '\'' +
        ", edad=" + edad + " años" + ". " + mensajeSobreEdad() +
        ", dni = '" + dni + '\'' +
        ", pesoEnKg = " + pesoEnKg +
        ", alturaEnM = " + alturaEnM +
        ", imc = " + mensajeImc(calcularImc()) +
        " }";
  }

  public String mensajeSobreEdad() {
    return esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad";
  }

  public String mensajeImc(int imc) {
    return switch (imc) {
      case -1 -> "Bajo peso";
      case 0 -> "Peso normal";
      case 1 -> "Sobrepeso";
      default -> throw new RuntimeException("Valor de IMC no esperado");
    };
  }
}
