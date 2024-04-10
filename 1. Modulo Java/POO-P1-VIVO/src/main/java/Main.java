import Persona.Persona;

public class Main {
    public static void main(String[] args) {
        Persona felipe = new Persona();
        Persona juan = new Persona("Juan",20,"56795039");
        Persona maria = new Persona("Maria",32, "23456789",60,1.60);

        // Crear esta persona no es posible Java lanza un error en tiempo de compilación debido
        // a que no existe un constructor para dichos parametros
        // Persona personaParametrosIncorrectos = new Persona("personaNoSoportada", 50);

        // Ejercicio 5 y 6 (esta en el toString de Persona)
        System.out.println(maria.toString());

    }
}
