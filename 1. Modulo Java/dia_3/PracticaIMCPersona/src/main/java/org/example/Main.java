package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Persona pesrona = new Persona();
        Persona persona2 = new Persona("Edwin", 23, "1234");
        Persona persona3 = new Persona("Steven", 32, "4321", 68, 1.65);
        //Persona personaError = new Persona("Julián"); genera un error ya que no existe contructor para un solo argumento.


        //System.out.println(persona3.calcularIMC());
        //System.out.println(persona3.esMayorDeEdad());
        System.out.println(persona3.toString());
        if(persona3.esMayorDeEdad())
            System.out.print("Es mayor de edad y ");
        else
            System.out.print("Es menor de edad y ");
        switch (persona3.calcularIMC()) {
            case -1:
                System.out.println("tiene bajo peso");
                break;
            case 0:
                System.out.println("su peso es saludable");
                break;
            case 1:
                System.out.println("tiene sobrepeso");
                break;
        }
        //resultado:
       // La Persona con los siguientes datos: nombre='Steven', edad=32, dni='4321', peso=68.0, altura=1.65
       // Es mayor de edad y su peso es saludable

    }


}
