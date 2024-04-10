package org.example;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Persona nuevaPersona = new Persona();
        Persona pepe = new Persona("Pepe", 12, "48398838");
        Persona jose = new Persona("Jose", 32, "35736284", 80.4, 1.82 );

        // este caso no es posible porque no tenemos un constructor que tome solo esos argumentos.
        //Persona ramiro = new Persona("Ramiro", 25);


        String joseEstado = "";
        if (jose.calcularIMC()<0){
            joseEstado  = "Bajo Peso";
        }
        if (jose.calcularIMC()==0){
            joseEstado  = "Peso Saludable";
        }
        if (jose.calcularIMC()>0){
            joseEstado  = "Sobre Peso";
        }

        System.out.println( "Segun el IMC de " + jose.getNombre() + " tiene un nivel de peso siguiente: " + joseEstado);

        if (jose.esMayorDeEdad()){
            System.out.println(jose.getNombre() + " es mayor de edad");
        }else{
            System.out.println(jose.getNombre() + " es menor de edad");
        }

        System.out.println(jose.toString());


    }
}
