package org.ggomezr;

public class Main {
    public static void main(String[] args) {
//      Instancia de objetos persona a partir de los diferentes constructores
        Persona personaConstructorVacio = new Persona();
        Persona personaConstructorTresArgumentos = new Persona("Geraldine", 20, "123456789");
        Persona personaConstructorCompleto = new Persona("Geraldine", 20, "123456789", "68", "1.65");
/*
        Instancia de objeto persona con datos que no corresponden a ningun constructor
        Persona personaConstructorIncompleto = new Persona("Geraldine", 20);
*/

//      Inicializacion de variables para el calculo del IMC y el mensaje para mostrar por pantalla
        int imc = personaConstructorCompleto.calcularIMC();
        String mensaje = "";

//       Evaluacion del imc con respecto a los datos de la persona
        switch (imc){
            case -1 -> mensaje = "El indice de masa corporal es por debajo de 20, el nivel de peso es bajo";
            case 0 -> mensaje = "El indice de masa corporal es entre 20 y 25, el nivel de peso es saludable";
            case 1 -> mensaje = "El indice de masa corporal es mayor de 25, el nivel de peso es sobrepeso";
        }

//      Mostrar si la persona es mayor de edad
        System.out.println(personaConstructorCompleto.getNombre() + " es mayor de edad: "+ personaConstructorCompleto.esMayorDeEdad());

//      Mostrar mensaje por pantalla con respecto a el calculo del IMC
        System.out.println(mensaje);

//      Mostrar informacion completa de la persona
        System.out.println(personaConstructorCompleto);
    }
}