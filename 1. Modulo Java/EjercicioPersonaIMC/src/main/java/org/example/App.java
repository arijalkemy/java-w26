package org.example;


public class App 
{
    public static void main( String[] args )
    {
        //Instanciando objetos Persona
        Persona persona1=new Persona();
        Persona persona2=new Persona("Manu2",23,"DNI");
        Persona persona3=new Persona("Manuel",24,"INE",85.5,1.86);
        ///Persona persona4=new Persona("manu",24); al no tener un constructor para este tipo de instancia con solo esos datos, es un error
        //Usando el metodo toString
        System.out.println(persona3.toString());
        //usando el metodo esMayoDeEdad
        if(persona3.esMayorDeEdad())
            System.out.print("La persona es mayor de edad y ");
        else
            System.out.print("La persona es menor de edad y ");
        //calculamos el imc de la perosona y mostramos un mensaje acorde al resultado usando un switch
        switch (persona3.calcularIMC()){
            case -1:
                System.out.println("tiene un peso bajo.");
                break;
            case 0:
                System.out.println("tiene un peso saludable.");
                break;
            case 1:
                System.out.println("tiene sobrepeso.");
                break;
        }
    }
}
