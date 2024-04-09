

public class Main {
    public static void main(String[] args){
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Andres", 26, "40721425");
        Persona personaTres = new Persona("Stella", 57, "17971432", 55.5, 1.67);
        //Persona personaCuatro = new Persona("Dylan"); no se puede generar una instancia con atributos faltantes sin que haya un constructor preparado
        int valorIMC = personaTres.calcularIMC();
        boolean mayoriaEdad = personaTres.esMayorDeEdad();

        System.out.println(personaTres.toString());
        switch (valorIMC){
            case -1:
                System.out.println("Bajo peso.");
                break;
            case 0:
                System.out.println("Peso saludable.");
                break;
            default:
                System.out.println("Sobrepeso.");
                break;
        }
    }
}
