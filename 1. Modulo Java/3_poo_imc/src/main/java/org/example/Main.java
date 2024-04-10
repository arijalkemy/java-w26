package org.example;

// Item 3) --------
public class Main {
    public static void main(String[] args) {

        // Item 4) --------
        Persona personaWithoutData = new Persona();
        Persona personaIncomplete = new Persona("Matias", 26, "40000000");
        Persona personaComplete = new Persona("Matias", 10, "40000000", 74.5F, 1.78F);

        // Persona persona2Params = new Persona("Matias", 26);
        // No puedo ya que no existe un constructor de la forma.

        // Item 6) --------
        switch (personaComplete.calcularIMC()){
            case -1:
                System.out.println("La persona posee bajo peso");
                break;
            case 0:
                System.out.println("La persona posee peso saludable");
                break;
            case 1:
                System.out.println("La persona posee sobrepeso");
            default:
                System.out.println("Error en el calculo del IMC");
        }
        // Imprimo si es mayor de edad
        System.out.println(personaComplete.getNombre() + ((personaComplete.esMayorDeEdad() ? "" : " no") ) +" es mayor de edad");

        // Imprimo datos de la persona. Llama al "toString"
        System.out.println(personaComplete);
    }
}