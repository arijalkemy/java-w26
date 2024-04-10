package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Persona personaSinParametros = new Persona();
        Persona personaTresParametros = new Persona("Lautaro Oleastro", 20, "40989847");
        Persona personaCincoParametros = new Persona("Lautaro Oleastro", 26, "40989847", 72.0,1.72);

        personaCincoParametros.calcularIMC();

        String estadoDePeso = "";
        switch (personaCincoParametros.calcularIMC()){
            case -1:
                estadoDePeso = "Bajo peso.";
                break;
            case 0:
                estadoDePeso = "Peso saludale.";
                break;
            case 1:
                estadoDePeso = "Sobrepeso.";
        }

        System.out.println(personaCincoParametros.toString());
        System.out.println(estadoDePeso);
        if (personaCincoParametros.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }
    }
}
