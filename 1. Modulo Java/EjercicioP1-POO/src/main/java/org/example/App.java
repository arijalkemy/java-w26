package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Persona personaSinParametros = new Persona();
        Persona personaConTresParametros = new Persona("Joaquin Oldani", 27, "39659904");
        Persona personaConTodosParametros = new Persona("Pepito Juarez", 31, "12345678", 75.7, 1.87);

        String resultadoIMC = "";
        switch (personaConTodosParametros.calcularIMC()) {
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

        if(personaConTodosParametros.esMayorDeEdad()){
            System.out.println(personaConTodosParametros.nombre + " es mayor de edad y tiene " + resultadoIMC);
        } else {
            System.out.println(personaConTodosParametros.nombre + " es menor de edad y tiene " + resultadoIMC);
        }

        System.out.println(personaConTodosParametros.toString());
    }
}
