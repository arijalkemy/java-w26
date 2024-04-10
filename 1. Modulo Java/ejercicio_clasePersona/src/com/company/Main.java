package com.company;

public class Main {

    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaSinPesoYAltura = new Persona("Jose", 25, "12345678");
        Persona personaConParametros = new Persona("Paula", 32, "12345677", 67.2f, 1.74f);

        // Si intentamos instanciar una persona pasando solamente el nombre y la edad
        // obtendremos el siguiente error: cannot resolve constructor 'Persona(java.lang.String, int)'
        // Esto suscede porque no se ha definido un constructor que reciba solo esos parámetros
        // Ejemplo comentado

        // Persona personaConError = new Persona("Carlos", 27);

        int imc = personaConParametros.calcularIMC();
        boolean esMayorDeEdad = personaConParametros.esMayorDeEdad();

        String[] mensajes = new String[] {
                "por debajo de 20",
                "bajo peso"
        };

        if (personaConParametros.calcularIMC() == 0) {
            mensajes[0] = "entre 20 y 25 inclusive";
            mensajes[1] = "peso saludable";
        }
        if (personaConParametros.calcularIMC() == 1) {
            mensajes[0] = "mayor de 25";
            mensajes[1] = "sobrepeso";
        }

        System.out.println(personaConParametros.toString());
        System.out.println(personaConParametros.getNombre() + " es " + (personaConParametros.esMayorDeEdad() ? "mayor" : "menor") + " de edad.");
        System.out.println("El IMC dio " + mensajes[0] + ", " + personaConParametros.getNombre() + " tiene " + mensajes[1]);
    }
}
