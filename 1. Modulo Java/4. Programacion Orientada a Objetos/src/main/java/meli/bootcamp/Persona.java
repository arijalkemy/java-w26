package meli.bootcamp;

public class Persona {
  String nombre;
  int edad;
  String dni;
  int peso;
  int altura;

  public Persona() {
  }

  public Persona(int edad, String nombre, String dni) {
    this.edad = edad;
    this.nombre = nombre;
    this.dni = dni;
  }

  public Persona(String nombre, int edad, String dni, int peso, int altura) {
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    this.peso = peso;
    this.altura = altura;
  }

}
