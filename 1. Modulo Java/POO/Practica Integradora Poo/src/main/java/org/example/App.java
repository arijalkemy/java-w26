package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args)// ejercicio 3
    {
        Persona personaSinParametros = new Persona();
        Persona personaTresParametros = new Persona("Matias", 27, "12344456");
        Persona personaConTodoParametros = new Persona("Marcos", 27, "12344456", 78, 1.80);
        //Persona personaDosParametros = new Persona("Matias",22); No funciona, le falta agregar por lo menos 1 parametro
        //No deja ejecutar el programa por erro

        int resultadoImc = personaConTodoParametros.calcularIMC();

        if (resultadoImc == -1) {
            System.out.println("Bajo peso");
        } else if (resultadoImc == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

        if(personaConTodoParametros.esMayorDeEdad())
        {
            System.out.println("Es mayor de edad");
        }
        else
        {
            System.out.println("No es mayor de edad");
        }

        personaConTodoParametros.toString();

    }
}
