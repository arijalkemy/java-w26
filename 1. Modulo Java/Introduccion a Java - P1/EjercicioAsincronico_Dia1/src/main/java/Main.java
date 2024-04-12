/*EJERCICIO 1

Un estudiante de programación intentó realizar declaraciones de variables con sus respectivos
tipos en Java pero tuvo varias dudas mientras lo hacía. A partir de esto, nos brindó su
código y pidió la ayuda de un desarrollador experimentado que pueda darle una mano.
¿Podrías verificar su código y realizar las correcciones necesarias?

    Pistas:
        Recordá que en Java cada línea de código tiene una forma particular de cerrarse.
        Recordá que Java es un lenguaje FUERTEMENTE TIPADO, por lo que el correcto tipo de
        dato es muy importante en la declaración de cada variable
*/



/*EJERCICIO 2
Un profesor de programación está corrigiendo los exámenes de sus estudiantes de la materia
Programación I para poder brindarles las correspondientes devoluciones. Uno de los puntos del
examen consistía en proponer nombres de variables, pero uno de los alumnos propuso nombres bastante
peculiares. ¿Podrías ayudar al profesor a detectar cuáles de estos nombres que utilizó el alumno no son correctos?

Pistas:
    Recordá que existen una serie de reglas a la hora de definir nombres de variables.
 */

public class Main {
    public static void main(String[] args){
        System.out.println("--- Ejercicio 1 ----");

        String apellido = "Gomez";
        int edad = 35;
        boolean nombreVariable = false;
        String sueldo = "45857.90";
        String nombre = "Julián";

        System.out.println(apellido);
        System.out.println(edad);
        System.out.println(nombreVariable);
        System.out.println(sueldo);
        System.out.println(nombre);

        System.out.println("\n--- Ejercicio 2 ----");

        //String 1nombre;
        String nombrePersona;
        int edadPersona;
        //double $ueldo;
        double sueldoPersona;
        //String @pellido;
        String apellidoPersona;
        String direccion;
        //boolean licencia_de_conducir;
        boolean licenciaDeConducir;
        //double estatura de la persona;
        double estaturaDeLaPersona;
        //int cantidad-de-hijos;
        int cantidadDeHijos;
        System.out.println("Se declararon las varibales de forma correcta. " +
                "A algunas se les modificó el nombre original debido que la variable ya se la estaba usando en " +
                "el mismo dominio");
    }
}