import javax.management.BadAttributeValueExpException;

public class Main {
    public static void main(String[] args) {

        Persona personaVacio = new Persona();
        Persona personaSinCar = new Persona("Persona", 20, "1234567");
        Persona personaCompleta = new Persona("Nombre", 21, "4567890", 80, 19.0);

        Persona personaSinDni = new Persona("Nombre", 20);

        System.out.println(personaSinDni.toString());
    }
}