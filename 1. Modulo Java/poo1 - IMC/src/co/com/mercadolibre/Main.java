package co.com.mercadolibre;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Persona personaSinParametros = new Persona();
        Persona persona3Parametros = new Persona("Rodrigo", 28, "10101276");
        Persona personaConParametros = new Persona("Rodrigo", 28, "10101276", 80.0, 1.83);

        System.out.println("Los datos de la perosna son: " + personaConParametros.toString());

        // Verificar mayoria de edad
        System.out.println(personaConParametros.esMayorDeEdad(personaConParametros.getEdad()) ? "La persona es mayor de edad" : "La persona es menor de edad");

        int resultadoIMC = personaConParametros.calcularIMC(personaConParametros.getPeso(), personaConParametros.getAltura());

        switch (resultadoIMC) {
            case -1:
                System.out.println("La persona se encuentra en bajo peso.");
                break;
            case 0:
                System.out.println("La persona tiene un peso saludable.");
                break;
            case 1:
                System.out.println("La persona tiene sobrepeso.");
                break;
            default:
                System.out.println("Valor de IMC no reconocido.");
        }
    }
}
