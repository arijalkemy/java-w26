package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Persona joaquin = new Persona();

        Persona juan = new Persona("Juan",25, "41234567");

        Persona pedro = new Persona("Pedro",15,"39475657",60.3,1.70);

        mostrarDatos(pedro);


    }

    public static void mostrarDatos(Persona p){

        switch (p.cacularIMC()){
            case -1:
                System.out.println(p.getNombre() + " Se encuentra con Bajo peso");
                break;
            case 0:
                System.out.println(p.getNombre() + " Se encuentra con un Peso saludable");
                break;
            case 1:
                System.out.println(p.getNombre() + " Se encuentra con Sobrepeso");
                break;
        }

        if (p.esMayorDeEdad()){
            System.out.println(p.getNombre() + " Es mayor de edad");
        }
        else {
            System.out.println(p.getNombre() + " Es menor de edad");
        }

        System.out.println(p.toString());
    }
}
