public class Main {

    public static void main(String[] args) {
        Persona personaConstructorVacio = new Persona();
        Persona personaPrimerConstructor = new Persona("Agustin", 26,"42404532");
        Persona personaSegundoConstructor = new Persona("Ezequiel", 23,"39484332", 10, 20);
        Persona personaEstatico = Persona.CrearPersonaSinDni("Ivan",17);

        String imcResultado = "";
        String mayorDeEdadResultado = personaSegundoConstructor.esMayorDeEdad() ? "mayor de edad" : "menor de edad";

        switch (personaSegundoConstructor.calcularIMC()) {
            case -1:
                imcResultado = "Bajo peso";
                break;
            case 0:
                imcResultado = "Peso saludable";
                break;
            default:
                imcResultado = "Sobre peso";
                break;
        }

        System.out.println("El indice de masa corporal de la persona es: " + imcResultado);
        System.out.println("La persona es: " + mayorDeEdadResultado);
        System.out.println(personaSegundoConstructor.toString());
    }
}
