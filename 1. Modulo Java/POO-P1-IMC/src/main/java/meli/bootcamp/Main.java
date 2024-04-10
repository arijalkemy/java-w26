package meli.bootcamp;

public class Main {
    public static void main(String[] args) {
        Persona personWithoutData = new Persona();
        Persona personWithSomeData = new Persona("Pedro", 20, "11223344");
        Persona personWithFullData = new Persona("Juan", 15, "22334455", 60, 1.75);

        switch (personWithFullData.calcularIMC()) {
            case -1:
                System.out.println("La persona tiene bajo peso");
                break;
            case 0:
                System.out.println("La persona tiene peso adecuado");
                break;
            case 1:
                System.out.println("La persona tiene sobrepeso ");
                break;
        }

        String mensajeEdad = personWithFullData.esMayorDeEdad() ? "La persona es mayor de edad" : "La persona es menor de edad";

        System.out.println(mensajeEdad);

        System.out.println(personWithFullData.toString());
    }
}
