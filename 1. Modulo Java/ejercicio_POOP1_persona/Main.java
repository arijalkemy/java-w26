import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Agustin", 22, "44");
        Persona persona3 = new Persona("Carlos", 21, "50", 87.5, 174);

        int valorIMC = persona1.calcularIMC();
        boolean esMayor = persona1.esMayorDeEdad();

        System.out.println(persona1.toString());

        switch (valorIMC) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            default:
                System.out.println("Sobrepeso");
                break;
        }
    }
}