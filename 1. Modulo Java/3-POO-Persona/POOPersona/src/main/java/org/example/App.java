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
        Persona persona3Parametros = new Persona("Maca", 29, "34567890");
        Persona personaTodosParametros = new Persona("Macarena", 29, "34567890", 50, 1.50);

        //Persona personaFail = new Persona("MacaFail", 20);

        int imc = personaTodosParametros.CalcularIMC();

        boolean esMayorDeEdad = personaTodosParametros.EsMayorDeEdad();

        String queIMCTiene;

        if(imc == -1) {
            queIMCTiene = "Bajo peso";
        } else if(imc == 0) {
            queIMCTiene = "Peso saludable";
        } else {
            queIMCTiene = "Sobre peso";
        }

        String esONoEs = "no";

        if(esMayorDeEdad) {
            esONoEs = "si";
        }

        System.out.println(personaTodosParametros.toString()+" tiene un IMC de "+queIMCTiene+
                " y "+esONoEs+" mayor de edad");
    }
}
