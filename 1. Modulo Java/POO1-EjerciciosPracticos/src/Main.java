import javax.management.BadAttributeValueExpException;

public class Main {
    public static void main(String[] args) {

        Persona personaVacio = new Persona();
        Persona personaSinCar = new Persona("Persona", 20, "1234567");
        Persona personaCompleta = new Persona("Nombre", 18, "4567890", 80, 19.0);



        Persona personaSinDni = new Persona("Nombre", 17);


        System.out.println("Persona sin Información:");
        System.out.println(personaVacio.toString() + "\n");
        System.out.println("Persona sin Caracteristicas Fisicas:");
        System.out.println(personaSinCar.toString() + "\n");
        System.out.println("Persona Con toda la Información:");
        System.out.println(personaCompleta.toString() + "\n");
        System.out.println("Persona sin DNI:");
        System.out.println(personaSinDni.toString() + "\n");


        System.out.println("Calculando desde main a persona completa");
        System.out.println("IMC:" + personaCompleta.calcularIMC());
        System.out.println("Es Mayor de Edad:" + personaCompleta.esMayorDeEdad());



    }
}