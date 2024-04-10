//Ejercicio 3 - Crear el main
public class Main {
    public static void main(String[] args) {

//Ejercicio 4 - Crear objetos
        Persona persona1 = new Persona();
        Persona personaALaMitad = new Persona("Emiliano",33,"123445667");
        Persona personaCompleta = new Persona("Jorge",32,"1234324",82.1,1.85);

        switch(personaCompleta.calcularIMC()){
            case 1:
                System.out.println("La persona " + personaCompleta.getNombre() + " tiene sobrepeso");
                break;
            case 0:
                System.out.println("La persona " + personaCompleta.getNombre() +" tiene peso saludable");
                break;
            case -1:
                System.out.println("La persona " + personaCompleta.getNombre() + " tiene bajo peso.");
                break;
        }
        System.out.println("La persona " + personaCompleta.getNombre() + " es " + (personaCompleta.esMayorDeEdad() ? "mayor" : "menor") + " de edad.");
        System.out.println("Los datos de la persona son los siguientes: \n"+personaCompleta.toString());
    }
}
