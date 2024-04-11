package org.src;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Persona personaConstructorVacio = new Persona();
        Persona personaConstructor3Parametros = new Persona("Joan", 26, "12345678");
        Persona personaConstructor5Parametros = new Persona("Joan", 26, "12345678", 90, 182);
        //Persona personaConstructorConError = new Persona("Joan", 30);

        String mensajeFinal = "La persona: \n"+personaConstructor5Parametros.toString();
        int imc = personaConstructor3Parametros.calcularIMC();
        if (personaConstructor5Parametros.esMayorDeEdad()) {
            mensajeFinal += "Es mayor de edad\n";
        } else {
            mensajeFinal += "No es mayor de edad\n";
        }

        switch (imc) {
            case -1:
                mensajeFinal += "Tiene bajo peso\n";
                break;
            case 0:
                mensajeFinal += "Tiene peso normal\n";
                break;
            case 1:
                mensajeFinal += "Tiene sobrepeso\n";
                break;
            default:
                mensajeFinal += "Error al calcular IMC\n";
                break;
        }
        System.out.println(mensajeFinal);
    }
}
