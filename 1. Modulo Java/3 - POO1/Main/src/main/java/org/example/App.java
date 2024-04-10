package org.example;

public class App 
{
    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaConTresParametros = new Persona("Joaquin Oldani", 27, "39659904");
        Persona personaConTodosParametros = new Persona("Pepito Juarez", 31, "12345678", 75.7, 1.87);

        int IMCpersona3 = personaConTodosParametros.calcularIMC();
        String resultadoIMC = "";
        switch (IMCpersona3) {
            case -1:
                resultadoIMC = "Bajo peso";
                break;

            case 0:
                resultadoIMC = "Peso saludable";
                break;

            case 1:
                resultadoIMC = "Sobrepeso";
                break;
            default:
                break;
        }
        System.out.println("El resultado del IMC de la persona es: " + resultadoIMC);

        String edadString;
        if (personaConTodosParametros.esMayorDeEdad()){
            edadString = "MAYOR";
        }
        else
        {
            edadString = "MENOR";
        }
        System.out.println("La persona es " + edadString + " de edad");

        System.out.println("Los datos de la persona elegida son los siguientes:");
        System.out.println(personaConTodosParametros.toString());
    }
}
