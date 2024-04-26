package com.bootcamp.excepcion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678A");
        Persona persona3 = new Persona("Pedro", 30, "87654321B", 80, 1.80f);

        //Persona persona4 = new Persona("Ana");
        //Persona persona5 = new Persona(35);

        // Cacluclo del IMC
        int imc = persona3.calcularIMC();
        String nombre = persona3.getNombre();
        if (imc == -1){
            System.out.println(nombre + " esta por debajo del peso ideal");
        } else if (imc == 0){
            System.out.println(nombre + " esta en su peso ideal");
        } else {
            System.out.println(nombre + " esta por encima de su peso ideal");
        }

        //Comprobacion de si es mayor de edad
        if (persona3.esMayorDeEdad()){
            System.out.println(nombre + " es mayor de edad");
        } else {
            System.out.println(nombre + " es menor de edad");
        }

        //Mostrar informacion
        System.out.println(persona3.toString());
    }
}
