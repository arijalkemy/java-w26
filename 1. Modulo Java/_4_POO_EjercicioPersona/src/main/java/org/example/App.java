package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona personaSinValorDeAtributos = new Persona();
        Persona personaConNombreEdadYDni = new Persona("Marcos", 23, "43333331");
        Persona personaConTodosLosAtributos = new Persona("Pedro", 18, "47039922", 72.5, 1.73);

        //NO se puede crear un objeto tipo persona con solo 2 parametros porque no existe el constructor
        //para eso
        //Persona persona4= new Persona("Marcos", 22);

        System.out.println("Datos de " + personaConTodosLosAtributos.nombre+ ": ");

        int imcPersonaConTodosLosAtributos = personaConTodosLosAtributos.calcularIMC();
        switch (imcPersonaConTodosLosAtributos){
            case -1:
                System.out.println("Bajo peso.");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        if(personaConTodosLosAtributos.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }
        else{
            System.out.println("Es menor de edad");
        }
        System.out.println(personaConTodosLosAtributos.toString());

        System.out.println("Datos de las demas personas");
        System.out.println(personaSinValorDeAtributos.toString());
        System.out.println(personaConNombreEdadYDni.toString());
    }
}
