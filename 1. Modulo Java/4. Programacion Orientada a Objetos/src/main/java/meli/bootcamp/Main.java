package meli.bootcamp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    Persona unaPersona = new Persona(22, "Valentin", "234342423");
    Persona otraPersona = new Persona();
    Persona unaPersonaCompleta = new Persona("Nicole", 99, "213211", 1, 1);

    // No compila:
    // Persona unaPersonaIncompleta = new Persona("nombre", 123);

    System.out.println("El imc de " + unaPersonaCompleta.nombre + " indica: " + mensajeImc(unaPersonaCompleta.calcularImc()));

    String mensajeSobreEdad = unaPersonaCompleta.esMayorDeEdad() ? "es mayor de edad" : "es menor de edad";
    System.out.println(unaPersonaCompleta.nombre + " " + mensajeSobreEdad);

    System.out.println(unaPersonaCompleta);
  }

  public static String mensajeImc(int imc) {
    return switch (imc) {
      case -1 -> "Bajo peso";
      case 0 -> "Peso normal";
      case 1 -> "Sobrepeso";
      default -> throw new RuntimeException("Valor de IMC no esperado");
    };
  }
}